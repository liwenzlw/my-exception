package com.example.exception;

/**
 * @author zenglw
 * @date 2018/7/10
 */
public class MyException extends RuntimeException {

    // 构造器 start

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    // 构造器 end
}
