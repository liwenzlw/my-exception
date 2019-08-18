package com.example.exception;

/**
 * 在HTTP返回响应结果时，提供一些参考信息
 * @author zenglw
 * @date 20190818
 */
public interface MyHttpResponseResultException {

    /**
     * 响应状态码
     * 示例：200 正常，500 服务的异常，400 参数不合法
     * @return
     */
    int getStatus();

    /**
     * 获取业务异常编号
     * @return
     */
    String getErrorCode();

    /**
     * 用户友好信息，用于返回界面给用户提示
     * @return
     */
    String getUserFriendlyMessage();

}
