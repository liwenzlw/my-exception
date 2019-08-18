package com.example.exception.support;

import com.example.exception.MyErrorCode;
import com.example.exception.MyHttpSupportException;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

/**
 * 校验异常
 * 约定：
 *  1. 该异常在全局处理的时候，会使用log.warn输出日志
 *  2. 全局处理返回的ResultVo.status=400, errorCode=400_c0001
 *  3. 必须是用户可以自行解决的错误信息，才可以通过该异常返回
 */
public class MyDefaultCheckException extends MyHttpSupportException {


    //-----------------构造器 start----------------------
    public MyDefaultCheckException() {
        super();
        init();
    }

    private MyDefaultCheckException(String message) {
        super(message);
        init();
    }

    public MyDefaultCheckException(Throwable cause) {
        super(cause);
        init();
    }

    private MyDefaultCheckException(String message, Throwable cause) {
        super(message, cause);
        init();
    }
    //-----------------构造器 end----------------------

    private void init() {
        this.setErrorCode(MyErrorCode.MyCommonCodeEnum.common_check);
        this.setStatus(HttpStatus.BAD_REQUEST.value());
        this.setLogLever(EnumTaLogLever.WARN);
    }

    // ---------------builder start-----------------

    /**
     * 使用格式化的message拼接异常消息
     *
     * @param message {@example "{}颜色的苹果很甜，但是它{}" }
     * @param params  {@example ["红","有毒"]}
     */
    public static MyDefaultCheckException build(String message, Object... params) {
        message = MessageFormat.format(message, params);
        return new MyDefaultCheckException(message);
    }

    /**
     * 使用格式化的message拼接异常消息
     *
     * @param message {@example "{}颜色的苹果很甜，但是它{}" }
     * @param params  {@example ["红","有毒"]}
     * @param e
     */
    public static MyDefaultCheckException build(String message, Throwable e, Object... params) {
        message = MessageFormat.format(message, params);
        return new MyDefaultCheckException(message, e);
    }


    public static MyDefaultCheckException build(String message, Throwable e, Object deliveryData, Object... params) {
        message = MessageFormat.format(message, params);
        MyDefaultCheckException serviceException = new MyDefaultCheckException(message, e);
        serviceException.setData(deliveryData);
        return serviceException;
    }

    public static MyDefaultCheckException build(String message, Throwable e, Object deliveryData, MyErrorCode errorCode, Object... params) {
        message = MessageFormat.format(message, params);
        MyDefaultCheckException serviceException = new MyDefaultCheckException(message, e);
        serviceException.setData(deliveryData);
        serviceException.setErrorCode(errorCode);
        return serviceException;
    }

    // ---------------builder end-----------------

}
