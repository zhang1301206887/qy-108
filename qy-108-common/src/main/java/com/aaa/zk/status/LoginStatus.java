package com.aaa.zk.status;

/**
 * @Author zk
 * @Date 2020/5/12
 */
public enum LoginStatus {

    LOGIN_SUSSESS("20001","登录成功"),
    LOGIN_FAILED("10001","登录失败"),
    USER_EXIST("20002", "用户存在"),
    USER_NOT_EXIST("10002", "用户不存在"),
    PASSWORD_WRONG("10003", "密码错误"),
    USER_LOCKED("10004", "账号被锁定"),
    LOGOUT_WRONG("10005", "用户退出异常"),
    DELETE("20003","删除成功"),
    DELETE_NOT("10006","删除失败"),
    UPDATE("20004","修改成功"),
    UPDATE_NOT("10007","修改失败"),
    SELECT("20005","查询成功"),
    SELECT_NOT("10008","查询失败"),
    PAGEINFO("20006","分页成功"),
    PAGEINFO_NOT("10009","分页失败");

    LoginStatus(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;

    public String getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }


}
