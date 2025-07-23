package com.itkf.oneflowplan.domain.entity;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 数据对象：审批流模版表，对应数据库表flow_plan_config。
 * 用于数据库表映射，通常与数据库表结构一一对应。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("flow_plan_config")
public class FlowPlanConfigDO {
    /** 审批流主键 */
    private String id;
    /** 审批流模版的名称 */
    private String name;
    /** 审批流模版的节点列表（JSON） */
    private String start;
    /** 审批流模版的状态 */
    private String state;
    /** 审批流模版最后一次编辑者 */
    private String editorId;
} 