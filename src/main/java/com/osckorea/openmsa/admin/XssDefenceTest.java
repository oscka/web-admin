package com.osckorea.openmsa.admin;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XssDefenceTest {

    @GetMapping("/xss")
    public String xssTest() {
        return "hello Xss Test";
    }

}
