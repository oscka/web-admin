package com.osckorea.openmsa.admin.rolecontrol;

import com.osckorea.openmsa.admin.rolecontrol.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserRoleService implements UserDetailsService {

    private final UserroleRepository userroleRepository;

    @Override
    public UserDetails loadUserByUsername(String user_nm) throws UsernameNotFoundException {
        UserInfo userInfo = userroleRepository.findByUserNm(user_nm);

        // roleId가 null인 경우 빈 리스트로 초기화
        List<String> roleId = userInfo.getRoleId() != null ? userInfo.getRoleId() : new ArrayList<>();

        // 사용자 정보를 UserDetails 객체로 변환하여 반환
        List<GrantedAuthority> authorities = roleId.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return org.springframework.security.core.userdetails.User.builder()
                .username(userInfo.getUserNm())
                .password(userInfo.getUserPw())
                .authorities(authorities)
                .build();
        }
    }




