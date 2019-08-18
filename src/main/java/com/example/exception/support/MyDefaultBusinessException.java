package com.example.exception.support;

import com.example.exception.MyErrorCode;
import com.example.exception.MyHttpSupportException;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

/**
 * 业务逻辑异常
 * 约定：
 *  1. 该异常在全局处理的时候，会使用log.error输出日志
 *  2. 该异常需要开发人员或运营人员处理
 *
 * 使用场景举例：发送通知失败，调用外部服务异常
 *
 * @author zenglw
 * @date 2018/4/26
 */
public class MyDefaultBusinessException extends MyHttpSupportException {

    //-----------------构造器 start----------------------
    public MyDefaultBusinessException() {
        super();
        init();
    }

    private MyDefaultBusinessException(String message) {
        super(message);
        init();
    }

    public MyDefaultBusinessException(Throwable cause) {
        super(cause);
        init();
    }

    private MyDefaultBusinessException(String message, Throwable cause) {
        super(message, cause);
        init();
    }
    //-----------------构造器 end----------------------

    private void init() {
        this.setErrorCode(MyErrorCode.MyCommonCodeEnum.common_business);
        this.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        this.setLogLever(EnumTaLogLever.ERROR);
    }


    // ---------------builder start-----------------

    /**
     * 使用格式化的message拼接异常消息
     *
     * @param message {@example "{0}颜色的苹果很甜，但是它{1}" }
     * @param params  {@example ["红","有毒"]}
     */
    public static MyDefaultBusinessException build(String message, Object... params) {
        message = MessageFormat.format(message,params);
        return new MyDefaultBusinessException(message);
    }

    /**
     * 使用格式化的message拼接异常消息
     *
     * @param message {@example "{0}颜色的苹果很甜，但是它{1}" }
     * @param params  {@example ["红","有毒"]}
     * @param e
     */
    public static MyDefaultBusinessException build(String message, Throwable e, Object... params) {
        message = MessageFormat.format(message,params);
        return new MyDefaultBusinessException(message, e);
    }


    public static MyDefaultBusinessException build(String message, Throwable e, Object deliveryData, Object... params) {
        message = MessageFormat.format(message, params);
        MyDefaultBusinessException serviceException = new MyDefaultBusinessException(message, e);
        serviceException.setData(deliveryData);
        return serviceException;
    }

    public static MyDefaultBusinessException build(String message, Throwable e, Object deliveryData, MyErrorCode errorCode, Object... params) {
        message = MessageFormat.format(message, params);
        MyDefaultBusinessException serviceException = new MyDefaultBusinessException(message, e);
        serviceException.setData(deliveryData);
        serviceException.setErrorCode(errorCode);
        return serviceException;
    }
    // ---------------builder end-----------------

}
