package com.aaa.zk.vo;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/21 16:40
 *@Description:
 */

import com.aaa.zk.model.Menu;
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
public class MenuVo implements Serializable {

    @Id
    @NotNull
    private Long id;

    @Max(value = 100,message ="时间长度最长不能超过100")
    private String createTime;

    @Max(value = 100,message ="时间长度最长不能超过100")
    private String modifyTime;
    /**
     * 上级菜单ID
     */
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    private String menuName;

    /**
     * 对应路由path
     */
    private String path;

    /**
     * 对应路由组件component
     */
    private String component;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    private String type;

    /**
     * 排序
     */
    private Double orderNum;

    private List<MenuVo> childrenList;
}
