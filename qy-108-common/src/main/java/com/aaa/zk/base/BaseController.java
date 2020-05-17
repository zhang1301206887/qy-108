package com.aaa.zk.base;
import static com.aaa.zk.status.LoginStatus.*;
/**
 * @Author zk
 * @Date 2020/5/12
 */
public class BaseController {
    /**
     *      登录成功，使用系统消息
     **/
   protected ResultData loginSuccess(){
       ResultData resultData = new ResultData();
       resultData.setCode(LOGIN_SUSSESS.getCode());
       resultData.setMsg(LOGIN_SUSSESS.getMsg());
       return resultData;
   }

    /**
     *      登录成功，使用自定义消息
     **/
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUSSESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      登录成功，使用系统消息，自定义返回值
     **/
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUSSESS.getCode());
        resultData.setMsg(LOGIN_SUSSESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     *      登录成功，自定义消息，自定义返回值
     **/
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUSSESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     *      登录失败，使用系统消息
     **/
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }
    /**
     *      用户存在，使用系统消息
     **/
    protected ResultData userExist() {
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }

    /**
     * 用户存在  使用自定义消息
     */
    protected ResultData userExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 用户存在  使用系统消息  自定义返回值
     */
//    protected ResultData userExist(Object data){
//        ResultData resultData = new ResultData();
//        resultData.setCode(USER_EXIST.getCode());
//        resultData.setMsg(USER_EXIST.getMsg());
//        resultData.setData(data);
//        return resultData;
//    }

    /**
     * 用户存在  使用自定义系统消息  自定义返回值
     */
//    protected ResultData userExist(String msg,Object data){
//        ResultData resultData = new ResultData();
//        resultData.setCode(USER_EXIST.getCode());
//        resultData.setMsg(msg);
//        resultData.setData(data);
//        return resultData;
//    }

    /**
     *      用户存在，使用系统消息
     **/
    protected ResultData userNotExist() {
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        return resultData;
    }

    /**
     * 用户存在  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData userNotExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 用户存在  使用系统消息  自定义返回值
     */
//    protected ResultData userNotExist(Object data){
//        ResultData resultData = new ResultData();
//        resultData.setCode(USER_NOT_EXIST.getCode());
//        resultData.setMsg(USER_NOT_EXIST.getMsg());
//        resultData.setData(data);
//        return resultData;
//    }

    /**
     * 用户存在  使用自定义系统消息  自定义返回值
     */
//    protected ResultData userNotExist(String msg,Object data){
//        ResultData resultData = new ResultData();
//        resultData.setCode(USER_NOT_EXIST.getCode());
//        resultData.setMsg(msg);
//        resultData.setData(data);
//        return resultData;
//    }

    /**
     *      密码错误，使用系统消息
     **/
    protected ResultData passwordWrong() {
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        return resultData;
    }

    /**
     * 密码错误  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData passwordWrong(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 密码错误  使用系统消息  自定义返回值
     */
//    protected ResultData passwordWrong(Object data){
//        ResultData resultData = new ResultData();
//        resultData.setCode(PASSWORD_WRONG.getCode());
//        resultData.setMsg(PASSWORD_WRONG.getMsg());
//        resultData.setData(data);
//        return resultData;
//    }

    /**
     * 密码错误  使用自定义系统消息  自定义返回值
     */
//    protected ResultData passwordWrong(String msg,Object data){
//        ResultData resultData = new ResultData();
//        resultData.setCode(PASSWORD_WRONG.getCode());
//        resultData.setMsg(msg);
//        resultData.setData(data);
//        return resultData;
//    }

    /**
     *      账号被锁定，使用系统消息
     **/
    protected ResultData userLocked() {
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(USER_LOCKED.getMsg());
        return resultData;
    }

    /**
     * 账号被锁定  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData userLocked(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_LOCKED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 账号被锁定  使用系统消息  自定义返回值
     */
//    protected ResultData userLocked(Object data){
//        ResultData resultData = new ResultData();
//        resultData.setCode(USER_LOCKED.getCode());
//        resultData.setMsg(USER_LOCKED.getMsg());
//        resultData.setData(data);
//        return resultData;
//    }

    /**
     * 账号被锁定  使用自定义系统消息  自定义返回值
     */
//    protected ResultData userLocked(String msg,Object data){
//        ResultData resultData = new ResultData();
//        resultData.setCode(USER_LOCKED.getCode());
//        resultData.setMsg(msg);
//        resultData.setData(data);
//        return resultData;
//    }

    /**
     *      用户退出异常，使用系统消息
     **/
    protected ResultData logoutWrong() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        return resultData;
    }

    /**
     * 用户退出异常  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData logoutWrong(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 用户退出异常  使用系统消息  自定义返回值
     */
//    protected ResultData logoutWrong(Object data){
//        ResultData resultData = new ResultData();
//        resultData.setCode(LOGOUT_WRONG.getCode());
//        resultData.setMsg(LOGOUT_WRONG.getMsg());
//        resultData.setData(data);
//        return resultData;
//    }

    /**
     * 用户退出异常  使用自定义系统消息  自定义返回值
     */
//    protected ResultData logoutWrong(String msg,Object data){
//        ResultData resultData = new ResultData();
//        resultData.setCode(LOGOUT_WRONG.getCode());
//        resultData.setMsg(msg);
//        resultData.setData(data);
//        return resultData;
//    }

    /**
     *      删除成功，使用系统消息
     **/
    protected ResultData delete() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE.getCode());
        resultData.setMsg(DELETE.getMsg());
        return resultData;
    }

    /**
     * 删除成功  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData delete(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      删除失败，使用系统消息
     **/
    protected ResultData deleteNot() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_NOT.getCode());
        resultData.setMsg(DELETE_NOT.getMsg());
        return resultData;
    }

    /**
     * 删除失败  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData deleteNot(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_NOT.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      修改成功，使用系统消息
     **/
    protected ResultData updata() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE.getCode());
        resultData.setMsg(UPDATE.getMsg());
        return resultData;
    }

    /**
     * 修改成功  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData updata(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *    修改失败，使用系统消息
     **/
    protected ResultData updateNot() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_NOT.getCode());
        resultData.setMsg(UPDATE_NOT.getMsg());
        return resultData;
    }

    /**
     * 修改失败  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData updateNot(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_NOT.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      查询成功，使用系统消息
     **/
    protected ResultData selelct() {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT.getCode());
        resultData.setMsg(SELECT.getMsg());
        return resultData;
    }

    /**
     * 查询成功  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData selelct(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      查询成功，使用系统消息，自定义返回值
     **/
    protected ResultData selelct(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT.getCode());
        resultData.setMsg(SELECT.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     *      查询成功，自定义消息，自定义返回值
     **/
    protected ResultData selelct(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }



    /**
     *   查询失败，使用系统消息
     **/
    protected ResultData selelctNot() {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT.getCode());
        resultData.setMsg(SELECT.getMsg());
        return resultData;
    }

    /**
     * 查询失败  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData selelctNot(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      分页成功，使用系统消息
     **/
    protected ResultData pageInfo() {
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO.getCode());
        resultData.setMsg(PAGEINFO.getMsg());
        return resultData;
    }

    /**
     * 分页成功  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData pageInfo(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      查询成功，使用系统消息，自定义返回值
     **/
    protected ResultData pageInfo(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO.getCode());
        resultData.setMsg(PAGEINFO.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     *      查询成功，自定义消息，自定义返回值
     **/
    protected ResultData pageInfo(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     *   分页失败，使用系统消息
     **/
    protected ResultData pageInfoNot() {
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO_NOT.getCode());
        resultData.setMsg(PAGEINFO_NOT.getMsg());
        return resultData;
    }

    /**
     * 分页失败  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData pageInfoNot(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO_NOT.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

}
