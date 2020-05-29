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
    protected ResultData deleteSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 删除成功  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData deleteSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      删除失败，使用系统消息
     **/
    protected ResultData deleteFalied() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(DELETE_FAILED.getMsg());
        return resultData;
    }

    /**
     * 删除失败  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData deleteFalied(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      修改成功，使用系统消息
     **/
    protected ResultData updataSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 修改成功  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData updataSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *    修改失败，使用系统消息
     **/
    protected ResultData updateFalied() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }

    /**
     * 修改失败  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData updateFalied(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      查询成功，使用系统消息
     **/
    protected ResultData selelctSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 查询成功  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData selelctSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      查询成功，使用系统消息，自定义返回值
     **/
    protected ResultData selelctSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     *      查询成功，自定义消息，自定义返回值
     **/
    protected ResultData selelctSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     *   查询失败，使用系统消息
     **/
    protected ResultData selelctFalied() {
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        return resultData;
    }

    /**
     * 查询失败  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData selelctFalied(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
    * @Author: He create on 2020/5/20 18:40
    * @param: []
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加成功 使用系统消息
    */
    protected ResultData insertSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(INSERT_SUCCESS.getMsg());
        return resultData;
    }
    /**
    * @Author: He create on 2020/5/20 18:40
    * @param: [msg]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加成功 使用自定义消息
    */
    protected ResultData insertSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
    * @Author: He create on 2020/5/20 18:42
    * @param: [msg]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 添加失败 自定义消息
    */
    protected ResultData insertFalied(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * @Author: He create on 2020/5/20 18:42
     * @param: [msg]
     * @return: com.aaa.zk.base.ResultData
     * @Description: 添加失败 使用系统消息
     */
    protected ResultData insertFalied(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(INSERT_FAILED.getMsg());
        return resultData;
    }

    /**
     *      分页成功，使用系统消息
     **/
    protected ResultData pageInfoSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO_SUCCESS.getCode());
        resultData.setMsg(PAGEINFO_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 分页成功  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData pageInfoSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     *      查询成功，使用系统消息，自定义返回值
     **/
    protected ResultData pageInfoSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO_SUCCESS.getCode());
        resultData.setMsg(PAGEINFO_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     *      查询成功，自定义消息，自定义返回值
     **/
    protected ResultData pageInfoSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     *   分页失败，使用系统消息
     **/
    protected ResultData pageInfoFalied() {
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO_FAILED.getCode());
        resultData.setMsg(PAGEINFO_FAILED.getMsg());
        return resultData;
    }

    /**
     * 分页失败  使用自定义消息
     * @param msg
     * @return
     */
    protected ResultData pageInfoFalied(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(PAGEINFO_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
    * @Author: He create on 2020/5/29 20:11
    * @param: []
    * @return: com.aaa.zk.base.ResultData
    * @Description: 文件上传成功 返回系统消息
    */
    protected ResultData uploadSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }
    /**
    * @Author: He create on 2020/5/29 20:12
    * @param: [msg]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 文件上传成功 返回自定义消息
    */
    protected ResultData uploadSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
    * @Author: He create on 2020/5/29 20:13
    * @param: []
    * @return: com.aaa.zk.base.ResultData
    * @Description: 文件上传失败 返回系统消息
    */
    protected ResultData uploadFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }
    /**
    * @Author: He create on 2020/5/29 20:13
    * @param: [msg]
    * @return: com.aaa.zk.base.ResultData
    * @Description: 文件上传失败 返回自定义消息
    */
    protected ResultData uploadFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
}
