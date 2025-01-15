package com.idv.demo.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idv.demo.models.dtos.ErrorMessage;
import com.idv.demo.utils.JsonSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(403);
        errorMessage.setMessage("Forbidden");
        response.getWriter().write(JsonSupport.objectToJson(errorMessage));
    }
}
