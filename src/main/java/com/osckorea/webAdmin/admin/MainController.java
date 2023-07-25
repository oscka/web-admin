package com.osckorea.webAdmin.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
@Slf4j
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "welcome";
    }

    //login

    //boardManage

    //
}
