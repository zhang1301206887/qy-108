package com.aaa.zk.vo;/*
 *@Company：
 *@Author：何康
 *@Date：2020/6/1 21:05
 *@Description:
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DeptVo implements Serializable {


    @Id
    @NotNull
    private Long id;

    @Max(value = 100,message ="时间长度最长不能超过100")
    private String createTime;

    @Max(value = 100,message ="时间长度最长不能超过100")
    private String modifyTime;
    /**
     * 上级部门ID
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 排序
     */
    private Double orderNum;

    private List<DeptVo> childrenList;
}
