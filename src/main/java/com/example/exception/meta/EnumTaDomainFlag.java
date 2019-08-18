package com.example.exception.meta;

enum EnumTaDomainFlag {
    student("st", "学员"),
    product("pd", "商品"),
    order("od", "订单"),
    account("ac", "账户"),
    attendance("at", "考勤"),
    finance("fi", "财务"),
    teacher("te", "教师"),
    ;

    private String code;

    private String desc;

    EnumTaDomainFlag(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
