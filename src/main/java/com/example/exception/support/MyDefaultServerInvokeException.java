package com.example.exception.support;

import com.example.exception.MyHttpSupportException;
import com.example.exception.MyServerInvokeException;
import com.example.exception.ResultVo;

import javax.validation.constraints.NotNull;
import java.text.MessageFormat;

/**
 * 服务调用异常
 * 约定：
 *  1. 不要创建该异常，该异常用户统一拦截Feign远程调用。当服务端返回status不等于200时，对响应结果进行封装，并抛出
 *
 * @author zenglw
 * @date 20190818
 */
public class MyDefaultServerInvokeException extends MyHttpSupportException implements MyServerInvokeException {

    /**
     * 远程服务名称
     */
    @NotNull
    private String serverName;

    /**
     * 远程服务响应信息
     */
    @NotNull
    private ResultVo serverResponse;

    private static final String messageTemplate = "调用“{0}”服务异常，服务返回信息为：{1}";

    @Override
    public String getServerName() {
        return this.serverName;
    }

    @Override
    public ResultVo getServerResponse() {
        return null;
    }


    //-----------------构造器 start----------------------
    public MyDefaultServerInvokeException() {
        super();
        init();
    }

    private MyDefaultServerInvokeException(String message) {
        super(message);
        init();
    }

    public MyDefaultServerInvokeException(Throwable cause) {
        super(cause);
        init();
    }

    private MyDefaultServerInvokeException(String message, Throwable cause) {
        super(message, cause);
        init();
    }
    //-----------------构造器 end----------------------

    private void init() {
        if(null != serverResponse) {
            this.setStatus(serverResponse.getStatus());
            this.setErrorCode(new MyDefaultErrorCode(serverResponse.getErrorCode()));
            switch (serverResponse.getStatus()) {
                case 500: this.setLogLever(EnumTaLogLever.ERROR); break;
                default: this.setLogLever(EnumTaLogLever.WARN); break;
            }
        }
    }


    // ---------------builder start-----------------
    public static MyDefaultServerInvokeException build(String serverName, ResultVo serverResponse) {
        String message = MessageFormat.format(messageTemplate, serverName,serverResponse);
        return new MyDefaultServerInvokeException(message);
    }
    // ---------------builder end-----------------
}
