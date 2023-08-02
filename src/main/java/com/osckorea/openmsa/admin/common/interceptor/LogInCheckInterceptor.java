package com.osckorea.openmsa.admin.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.osckorea.openmsa.admin.auth.domain.UserSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInCheckInterceptor implements HandlerInterceptor{
    /**
     * Configuration에서 지정된 Route Path에서,
     * Controller가 호출되기 이전에 실행해야 할 작업이 수행됩니다.
     * 
     * @param HttpServletRequest requesst
     * @param HttpServeltResponse response
     * @return boolean
     * @throws Exception
     */
    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
    ) throws Exception {
        HttpSession session = request.getSession(false);

        // 세션이 없거나, UserSession 속성 값이 없는 경우에는,
        if (session != null ? session.getAttribute("UserSession") == null ? true : false : true) {
            log.warn("[ LogIn Check Interceptor ] Unauthorized Access");

            // 로그인 페이지로 Redirection 시킵니다.
            response.sendRedirect(request.getContextPath() + "/main/login");

            return false; // Controller에 진입하지 않습니다.
        }

        return true; // Controller로 진입합니다.
    }

    /**
     * Controller가 호출되고나서,
     * HTML Template이 Render 되기 이전까지의 진행해야 할 작업을 수행합니다.
     * 
     * @param HttpServletRequest request
     * @param HttpServletResponse response
     * @param Object handler
     * @param ModelAndView modelAndView
     * @throws Exception
     */
    public void postHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        ModelAndView modelAndView
    ) throws Exception {
        UserSession userSessionData = (UserSession) request.getSession(false).getAttribute("UserSession");

        // 사용자 세션 정보가 존재한다면, HTML 템플릿 내의 `user` 객체로, 해당 정보를 넘겨줍니다.
        if (userSessionData != null) {
            modelAndView.getModel().put("user", userSessionData);
        }
    }
}
