package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.mapper.UserMapper;
import com.aaa.zk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.aaa.zk.staticstatus.UserStatus.*;

@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserMapper userMapper;
    /**
     * 查询所有用户
     * @return
     */

    public List<User> userSlelectAll(){

        List<User> list = userMapper.selectAll();
        // 判断list是否为空
        if (null !=list && !"".equals(list)){
            // 不为空返回
            return list;
        }else {
            // 为空返会null
            return null;
        }
    }

    /**
     * 查询一条数据
     */
    public User userSelectOne(User user){
        // 判断user是否为空
        if (user !=null){
            // 不为空 调用selectone查询数据
            User one = userMapper.selectOne(user);
            if (null != one && !"".equals(one)){
                return one;
            }else {
                // 为空返回null
                return null;
            }
        }else {
            // 为空返回null
            return null;
        }

    }

    /**
     * 添加用户
     */

    public Integer userAdd(User user){
        // 当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        // 把时间存到 user实体类中
        user.setCreateTime(format);
        Integer i = null;
        try {
            i = super.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 判断i是否大于0 如果大于则添加成功
        if (i>0){
            // 添加成功
            return i;
        }else {
            //添加失败
            return null;
        }
    }

    /**
     * 修改用户信息
     */

    public Integer userUpdate(User user){
        // 当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        // 把时间存到 user实体类中
        user.setModifyTime(format);
        int i = userMapper.updateByPrimaryKeySelective(user);
        // 判断i是否大于0 如果大于则添加成功
        if (i>0){
            // 添加成功
            return i;
        }else {
            //添加失败
            return null;
        }
    }

    /**
     * 通过主键删除
     */

    public Integer userDelete(User user) {
        // 调用delete删除方法
        Integer i = userMapper.delete(user);
        // 判断i是否大于0 如果大于则添加成功
        if (i>0){
            // 添加成功
            return i;
        }else {
            //添加失败
            return null;
        }
    }
    /**
     * 通过主键批量删除
     */
    public Integer userDeleteAll(String ids) {
        // 使用string的split方法来分割ids
        String[] s = ids.split(",");
        int i =0;
        // 循环删除
        for (int j=0 ;j< s.length;j++){
            // 把string转化为long类型
            Long a = Long.parseLong(s[j]);
            User user = new User();
            user.setId(a);
            // 删除
             i = userMapper.delete(user);
        }
        // 判断i是否大于0 如果大于则添加成功
        if (i>0){
            // 添加成功
            return i;
        }else {
            //添加失败
            return null;
        }
    }
    /**
     * 密码重置
     */
    public Integer UserPassword(User user){
        // 把重置的密码set到user实体类中
        user.setPassword(RESET_PASSWORD);
        int i = userMapper.updateByPrimaryKeySelective(user);
        // 判断i是否大于0 如果大于则添加成功
        if (i>0){
            // 添加成功
            return i;
        }else {
            //添加失败
            return null;
        }
    }

    /**
     * 用户重置
     */
    public Integer resetUser(User user){
        // 当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        // 把user实体类中的都清空
        user.setPassword(RESET_PASSWORD).setAvatar(null).setDeptId(null).setDescription(null).setEmail(null).setUsername(null).setSsex(null).setType(null).setAvatar(null).setToken(null).setStatus(null).setMobile(null).setModifyTime(format);
        System.out.println(user);
        // 调用updateByPrimaryKeySelective 方法 选择性的把数据给清空掉
        int i = userMapper.updateByPrimaryKeySelective(user);
        // 判断i是否大于0 如果大于则添加成功
        if (i>0){
            // 添加成功
            return i;
        }else {
            //添加失败
            return null;
        }
    }
}