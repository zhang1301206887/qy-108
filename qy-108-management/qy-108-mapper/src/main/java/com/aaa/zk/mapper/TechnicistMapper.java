package com.aaa.zk.mapper;

import com.aaa.zk.model.Technicist;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TechnicistMapper extends Mapper<Technicist> {

    @Select("select * from t_technicist where user_id = #{userid}")
    public List<Technicist> selectTechByUserId(Object userId);

}