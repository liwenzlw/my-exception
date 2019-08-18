package com.example.exception;

/**
 * 教务系统，异常编码接口
 * @author zenglw
 * @date 20190814
 */
public interface MyErrorCode {
    String getErrorCode();
    default String getErrorDesc() {
        return "";
    };

    /**
     * 通用异常code枚举
     * @author zenglw
     * @date 20190814
     */
    enum MyCommonCodeEnum implements MyErrorCode {

        /**
         * 必须是用户可以自行解决的错误，才可以通过该异常返回。
         * 参考关键字：客户端错误，操作校验错误，数据正确性校验错误
         */
        common_check("通用校验异常","400_c0001"),
        /**
         *
         */
        common_authorized("通用认证异常","500_b0001"),
        common_business("通用业务异常","500_b0001"),
        common_server("通用服务端运行时异常","500_r0001");
        /**
         * 异常code描述
         */
        private String desc;

        private String errorCode;

        MyCommonCodeEnum(String desc, String errorCode) {
            this.desc = desc;
            this.errorCode = errorCode;
        }

        @Override
        public String getErrorCode() {
            return errorCode;
        }

        @Override
        public String getErrorDesc() {
            return desc;
        }

    }
}
