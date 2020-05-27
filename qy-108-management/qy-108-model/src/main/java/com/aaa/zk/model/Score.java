package com.aaa.zk.model;

import com.aaa.zk.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_score")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Score extends BaseModel {

    /**
     * 增加的分值
     */
    @Column(name = "score_plus")
    private Integer scorePlus;

    /**
     * 减少的分值
     */
    @Column(name = "score_subtract")
    private Integer scoreSubtract;

    /**
     * 当前分值
     */
    private Integer score;

    /**
     * 关联单位编号
     */
    @Column(name = "unit_id")
    private Long unitId;

    /**
     * 增加/减少分值的原因
     */
    private String reason;

}