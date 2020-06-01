package com.aaa.zk.service;

import com.aaa.zk.base.BaseService;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.mapper.UserMapper;
import com.aaa.zk.model.User;
import com.aaa.zk.redis.RedisService;
import com.aaa.zk.utils.IDUtils;
import com.aaa.zk.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aaa.zk.staticstatus.RedisProperties.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/15 16:23
 * @Description
 **/
@Service
public class LoginService extends BaseService<User> {

    @Autowired
    private UserMapper userMapper;
    /**
     * @Author: He create on 2020/5/15 18:16
     * @param: [user, redisService]
     * @return: com.aaa.hk.vo.TokenVo
     * @Description: 登录操作
     */
    public TokenVo doLogin(User user , RedisService redisService){
        TokenVo tokenVo = new TokenVo();
        tokenVo.setIfSuccess(false);
        //首先判断传入的user不为空
        if (null != user){
            //验证用户传入的username和password是否正确
            User u = userMapper.selectOne(user);
            System.out.println(u);
            //如果为空 证明不存在
            if (null != u){
                //登陆成功
                String token = IDUtils.getUUID();
                u.setToken(token);
                //进行无状态登录 再数据库中进行token的更新
                int updateResult = userMapper.updateByPrimaryKey(u);
                //判断token是否更新成功
                if (updateResult > 0){
                    //证明token更新成功 需要返回token 并且给token设置失效时间
                    //因为以后每一个方法都需要去查询token，也就是说必须要查询数据库
                    //就会大量影响效率(所以说直接存缓存)
                    String setResult = redisService.set(String.valueOf(u.getId()), token, XX, EX, 1800);
                    if ("OK".equals(setResult.toUpperCase()) || "1".equals(setResult)){
                        return tokenVo.setIfSuccess(true).setToken(token).setRedisKey(String.valueOf(u.getId()));
                    }
                }
            }
        }
        return tokenVo;
    }
}
