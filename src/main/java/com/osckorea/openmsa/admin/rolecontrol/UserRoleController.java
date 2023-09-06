package com.osckorea.openmsa.admin.rolecontrol;

import com.osckorea.openmsa.admin.auth.domain.UserSession;
import com.osckorea.openmsa.admin.rolecontrol.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class UserRoleController {

    private final UserRoleService userRoleService;

    @GetMapping("/roletest")
    public String roleTestPage() {
        return "pages/roletest";
    }

    // 권한 관리 페이지로 이동
    @GetMapping("/controlpage")
    public String controlepage() {
        return "pages/authoritylogin";
    }

    // 로그인절차 (id,password, role 확인), 후 securityContext 객체  생성하고 저장 조회
    @PostMapping("/login")
    public String adminLogin(@RequestParam String user_nm,
                             @RequestParam String user_pw) {

        // 인증 단계(DB에 다녀오는 과정)
        UserDetails userinfo = userRoleService.loadUserByUsername(user_nm);
        if (userinfo != null && user_pw.equals(userinfo.getPassword())) {

            log.info("로그인 성공");

            // 인증 객체 생성
            Authentication authentication = new UsernamePasswordAuthenticationToken(userinfo, null, userinfo.getAuthorities());

            // SecurityContextHolder에 인증 객체 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 사용자 정보 출력
            log.info("현재 로그인된 사용자 이름: " + userinfo.getUsername());
            log.info("현재 로그인된 사용자 권한: " + userinfo.getAuthorities());
            log.info("인증 객체 정보: " + authentication.toString());

            // UserDetails 정보 출력
            log.info("UserDetails 정보: " + userinfo.toString());

            return "redirect:/main"; // 인가 실패 시 다른 페이지로 이동
        } else {
            // 비밀번호 불일치 시 로그인 실패
            log.info("로그인 실패");
            return "redirect:/main"; // 로그인 실패 시 다른 페이지로 이동
        }
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            log.info("로그 아웃 로직 실행");
        }
        return "redirect:/admin/login"; // 로그아웃 후 로그인 페이지로 이동
    }
}
