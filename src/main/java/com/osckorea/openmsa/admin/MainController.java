package com.osckorea.openmsa.admin;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.osckorea.openmsa.admin.auth.domain.UserSession;

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping("/")
    public String mainPage(
        Model model,
        HttpSession session
    ) {
        UserSession sessionStoreData = (UserSession) session.getAttribute("UserSession");

        if(sessionStoreData != null) {
            model.addAttribute("user", sessionStoreData.getUser());
        }

        return "welcome";
    }

    //login
    @GetMapping("/login")
    public String loginPage() {
        return "Pages/login";
    }

    //boardManage
    @GetMapping("/boardManagement")
    public String boardManagementPage() {
        return "pages/boardmanagement";
    }

    // join
    @GetMapping("/join")
    public String joinPage() {
        return "pages/join";
    }

    //
    @GetMapping("/viewmanagement")
    public String viewManagementPage() {
        return "pages/viewmanagement";
    }
}

