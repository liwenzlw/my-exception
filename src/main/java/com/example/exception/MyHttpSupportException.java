package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;

public abstract class MyHttpSupportException extends MyException implements MyHttpResponseResultException, MyLogException, MyDataTransferException {


    /**
     * 传递参数值
     */
    private Object data;

    /**
     * 响应 ResultVo中的status （HTTP状态码）
     */
    @NotNull
    private int status = HttpStatus.INTERNAL_SERVER_ERROR.value();

    /**
     * 客户端界面呈现的信息
     */
    private String userFriendlyMessage = "";

    /**
     * 错误异常编码
     */
    @NotNull
    private MyErrorCode errorCode;

    /**
     * 日志级别
     */
    @NotNull
    private EnumTaLogLever logLever;


    @Override
    public EnumTaLogLever getLogLevel() {
        return logLever;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getErrorCode() {
        return errorCode.getErrorCode();
    }

    @Override
    public String getUserFriendlyMessage() {
        return StringUtils.isEmpty(this.userFriendlyMessage) ? getMessage(): this.userFriendlyMessage;
    }

    @Override
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setErrorCode(MyErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUserFriendlyMessage(String userFriendlyMessage) {
        this.userFriendlyMessage = userFriendlyMessage;
    }

    protected void setLogLever(EnumTaLogLever logLever) {
        this.logLever = logLever;
    }

    // 构造器 start

    public MyHttpSupportException() {
        super();
    }

    public MyHttpSupportException(String message) {
        super(message);
    }

    public MyHttpSupportException(Throwable cause) {
        super(cause);
    }

    public MyHttpSupportException(String message, Throwable cause) {
        super(message, cause);
    }

    // 构造器 end
}
