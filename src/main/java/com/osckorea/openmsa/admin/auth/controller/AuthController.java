package com.osckorea.openmsa.admin.auth.controller;

import javax.servlet.http.HttpSession;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.osckorea.openmsa.admin.auth.domain.UserSession;
import com.osckorea.openmsa.admin.auth.service.AuthService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(
        value = "/loginSubmit",
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    ) public String loginSubmitRequest(
        UserSession.SignInPayload userInfo,
        HttpSession session
    ) {
        UserSession userSessionData = this.authService.signIn(userInfo);
        
        if(userSessionData == null) {
            return "redirect:/main/login";
        }

        session.setAttribute("UserSession", userSessionData);

        return "redirect:/main/";
    }

    @GetMapping("/logout")
    public String logoutRequest(HttpSession session) {
        session.removeAttribute("UserSession");

        return "redirect:/main/";
    }
}
