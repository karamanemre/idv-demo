package com.idv.demo.services.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;

@Slf4j
public class LogConsole {
    public static void info(String var1) {
        log.info(var1);
    }

    public static void info(String var1, Object var2) {
        log.info(var1, var2);
    }

    public static void info(String var1, Object var2, Object var3) {
        log.info(var1, var2, var3);
    }

    public static void info(String var1, Object... var2) {
        log.info(var1, var2);
    }

    public static void info(String var1, Throwable var2) {
        log.info(var1, var2);
    }

    public static void info(Marker var1, String var2) {
        log.info(var1, var2);
    }

    public static void info(Marker var1, String var2, Object var3) {
        log.info(var1, var2, var3);
    }

    public static void info(Marker var1, String var2, Object var3, Object var4) {
        log.info(var1, var2, var3, var4);
    }

    public static void info(Marker var1, String var2, Object... var3) {
        log.info(var1, var2, var3);
    }

    public static void info(Marker var1, String var2, Throwable var3) {
        log.info(var1, var2, var3);
    }

    public static void error(String var1) {
        log.error(var1);
    }

    public static void error(String var1, Object var2) {
        log.error(var1, var2);
    }

    public static void error(String var1, Object var2, Object var3) {
        log.error(var1, var2, var3);
    }

    public static void error(String var1, Object... var2) {
        log.error(var1, var2);
    }

    public static void error(String var1, Throwable var2) {
        log.error(var1, var2);
    }

    public static void error(Marker var1, String var2) {
        log.error(var1, var2);
    }

    public static void error(Marker var1, String var2, Object var3) {
        log.error(var1, var2, var3);
    }

    public static void error(Marker var1, String var2, Object var3, Object var4) {
        log.error(var1, var2, var3, var4);
    }

    public static void error(Marker var1, String var2, Object... var3) {
        log.error(var1, var2, var3);
    }

    public static void error(Marker var1, String var2, Throwable var3) {
        log.error(var1, var2, var3);
    }

    public static void warn(String var1) {
        log.warn(var1);
    }

    public static void warn(String var1, Object var2) {
        log.warn(var1, var2);
    }

    public static void warn(String var1, Object... var2) {
        log.warn(var1, var2);
    }

    public static void warn(String var1, Object var2, Object var3) {
        log.warn(var1, var2, var3);
    }

    public static void warn(String var1, Throwable var2) {
        log.warn(var1, var2);
    }

    public static void warn(Marker var1, String var2) {
        log.warn(var1, var2);
    }

    public static void warn(Marker var1, String var2, Object var3) {
        log.warn(var1, var2, var3);
    }

    public static void warn(Marker var1, String var2, Object var3, Object var4) {
        log.warn(var1, var2, var3, var4);
    }

    public static void warn(Marker var1, String var2, Object... var3) {
        log.warn(var1, var2, var3);
    }

    public static void warn(Marker var1, String var2, Throwable var3) {
        log.warn(var1, var2, var3);
    }
}
