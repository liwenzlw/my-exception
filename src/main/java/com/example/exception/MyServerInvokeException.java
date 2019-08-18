package com.example.exception;

/**
 * 远程服务调用异常
 *
 */
public interface MyServerInvokeException {

    /**
     * 远程服务名称
     * @return
     */
    String getServerName();

    /**
     * 远程服务响应
     * @return
     */
    ResultVo getServerResponse();
}
