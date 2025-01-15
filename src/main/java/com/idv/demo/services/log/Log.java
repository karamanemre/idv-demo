package com.idv.demo.services.log;

public interface Log {
    void error(Throwable error, Class<?> clazz);

    void error(Object payload, Throwable error, Class<?> clazz);
}
