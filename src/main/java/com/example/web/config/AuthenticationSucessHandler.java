package com.example.web.config;

import com.example.web.entity.User;
import com.example.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthenticationSucessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private LoginService loginService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String Username = authentication.getName();

        User user = loginService.findbyUsername(Username);

        //Place in session
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user",user);

        //Send response
        response.sendRedirect(request.getContextPath() + "/main/?user=" + user.getId());
    }
}
