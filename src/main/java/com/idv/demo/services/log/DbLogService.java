package com.idv.demo.services.log;

import com.idv.demo.entities.LogEntity;
import com.idv.demo.repository.LogRepository;
import com.idv.demo.utils.DateUtil;
import com.idv.demo.utils.JsonSupport;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service("DbLogService")
@RequiredArgsConstructor
public class DbLogService implements Log {

    private final LogRepository logRepository;

    @Override
    public void error(Throwable error, Class<?> clazz) {
        this.processData(null, error, clazz, LogEntity.LogLevel.ERROR);
    }

    @Override
    public void error(Object payload, Throwable error, Class<?> clazz) {
        this.processData(payload, error, clazz, LogEntity.LogLevel.ERROR);
    }

    private void processData(Object payload, Throwable throwable, Class<?> clazz, LogEntity.LogLevel logLevel) {
        LogEntity entity = new LogEntity();
        entity.setUsername("username");
        entity.setTimestamp(DateUtil.getCurrentDate());

        if (payload != null) {
            try {
                entity.setPayload(JsonSupport.objectToJson(payload));
            } catch (RuntimeException e) {

            }
        }

        HttpServletRequest httpServletRequest = this.getHttpServletRequest();
        entity.setRequestMethod(httpServletRequest != null ? httpServletRequest.getMethod() : null);
        entity.setRequestUri(httpServletRequest != null ? httpServletRequest.getRequestURI() : null);
        entity.setClassName(clazz.getName());
        entity.setLogLevel(logLevel);
        entity.setErrorMessage(getThrowableMessage(throwable));
        this.logRepository.save(entity);
    }

    private String getThrowableMessage(Throwable throwable) {
        if (throwable != null) {
            return ExceptionUtils.getStackTrace(throwable);
        }
        return null;
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }
}
