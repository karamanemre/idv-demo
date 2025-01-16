package com.idv.demo.services.log;

import org.springframework.stereotype.Service;

@Service("FileLogService")
public class FileLogService implements Log {

    @Override
    public void error(Throwable error, Class<?> clazz) {
        // can be file log
    }

    @Override
    public void error(Object payload, Throwable error, Class<?> clazz) {
        // can be file log
    }
}
