package com.osckorea.openmsa.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class UserRoleController {


    // 권한 관리 페이지로 이동
    @GetMapping("/controlpage")
    public String controlepage() {
        return "authoritycontrol";
    }

    // 권한 관리 기능



}
