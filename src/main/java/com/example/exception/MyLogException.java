package com.example.exception;

public interface MyLogException {

    EnumTaLogLever getLogLevel();

    /**
     * 日志级别
     * @author zenglw
     * @date 2019/8/2
     */
    enum EnumTaLogLever {

        TRACE("trace"), DEBUG("debug"), INFO("info"), WARN("warn"), ERROR("error");

        private String value;

        EnumTaLogLever(String value) {
            this.value = value;
        }
    }
}
