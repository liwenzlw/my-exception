package com.example.exception.support;

import com.example.exception.MyErrorCode;

/**
 * 错误编码默认实现
 * @author zenglw
 * @date 20190818
 */
public class MyDefaultErrorCode implements MyErrorCode {

    private String errorCode;

    private String errorDesc;

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorDesc() {
        return errorDesc;
    }

    public MyDefaultErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public MyDefaultErrorCode(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }


}
