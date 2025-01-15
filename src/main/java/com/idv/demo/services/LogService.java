package com.idv.demo.services;

import com.idv.demo.services.log.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private final Log log;

    public LogService(@Qualifier("DbLogService") Log log) {
        this.log = log;
    }

    public void error(Throwable error, Class<?> clazz) {
        this.log.error(error, clazz);
    }
}
