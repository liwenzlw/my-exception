package com.example.exception;

/**
 * Exception支持传输业务对象
 * @author zenglw
 * @date 20190814
 */
public interface MyDataTransferException {
    default Object getData() {
        return null;
    };
}
