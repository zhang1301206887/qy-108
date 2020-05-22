package com.aaa.zk.model;

import com.aaa.zk.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Role extends BaseModel {

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "REMARK")
    private String remark;

}