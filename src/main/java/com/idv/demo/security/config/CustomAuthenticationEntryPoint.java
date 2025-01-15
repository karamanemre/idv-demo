package com.idv.demo.security.config;

import com.idv.demo.models.dtos.ErrorMessage;
import com.idv.demo.utils.JsonSupport;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(401);
        errorMessage.setMessage("Access denied");
        response.getWriter().write(JsonSupport.objectToJson(errorMessage));
    }
}
