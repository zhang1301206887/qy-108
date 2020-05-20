package com.aaa.zk.model;

import com.aaa.zk.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_dept")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept extends BaseModel {

    /**
     * 上级部门ID
     */
    @Column(name = "PARENT_ID")
    private Long parentId;

    /**
     * 部门名称
     */
    @Column(name = "DEPT_NAME")
    private String deptName;

    /**
     * 排序
     */
    @Column(name = "ORDER_NUM")
    private Double orderNum;

}