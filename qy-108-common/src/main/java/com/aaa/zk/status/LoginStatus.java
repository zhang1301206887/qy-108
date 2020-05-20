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
    DELETE_SUCCESS("20003","删除成功"),
    DELETE_FAILED("10006","对不起，删除失败"),
    UPDATE_SUCCESS("20004","修改成功"),
    UPDATE_FAILED("10007","对不起，修改失败"),
    SELECT_SUCCESS("20005","查询成功"),
    SELECT_FAILED("10008","对不起，查询失败"),
    INSERT_SUCCESS("20006","添加成功"),
    INSERT_FAILED("10009","对不起，添加失败"),
    PAGEINFO_SUCCESS("20007","分页查询成功"),
    PAGEINFO_FAILED("10010","对不起，分页查询失败");

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
