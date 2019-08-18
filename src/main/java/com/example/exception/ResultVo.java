package com.example.exception;


import com.example.exception.support.MyDefaultServerInvokeException;
import org.springframework.http.HttpStatus;

public class ResultVo<T> {

    /**
     * http请求状态码
     */
    private int status;
    /**
     * 错误编码
     */
    private String errorCode;

    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;


    private ResultVo() {
    }

    public T getElseThrow() {
        if(HttpStatus.OK.value() != status) {
            throw MyDefaultServerInvokeException.build(null,this);
        }
        return data;
    }

    public static <T> ResultVo<T> success(T data) {
        ResultVo result = new ResultVo();
        result.status = HttpStatus.OK.value();
        result.data = data;
        return result;
    }

    public static <T> ResultVo<T> success() {
        ResultVo result = new ResultVo();
        result.status = HttpStatus.OK.value();
        return result;
    }

    public static <T> ResultVo<T> success(T data,String msg) {
        ResultVo result = new ResultVo();
        result.status = HttpStatus.OK.value();
        result.msg = msg;
        result.data = data;
        return result;
    }

    public static <T> ResultVo<T> error(String msg) {
        ResultVo result = new ResultVo();
        result.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        result.msg = msg;
        return result;
    }

    public static <T> ResultVo<T> error(T data,String msg) {
        ResultVo result = new ResultVo();
        result.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        result.msg = msg;
        result.data = data;
        return result;
    }

    public static <T> ResultVo<T> error(T data,String msg,String errorCode) {
        ResultVo result = new ResultVo();
        result.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        result.msg = msg;
        result.data = data;
        result.errorCode = errorCode;
        return result;
    }

    public static <T> ResultVo<T> error(int status, T data,String msg,String errorCode) {
        ResultVo result = new ResultVo();
        result.status = status;
        result.msg = msg;
        result.data = data;
        result.errorCode = errorCode;
        return result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
