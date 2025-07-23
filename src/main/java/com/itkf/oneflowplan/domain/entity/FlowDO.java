package com.itkf.oneflowplan.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 数据对象：单据表，对应数据库表flow。
 * 用于数据库表映射，通常与数据库表结构一一对应。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("flow")
public class FlowDO {
    /** 单据主键 */
    private String id;
    /** 提交人Id */
    private String ownerId;
    /** 单据数据（JSONObject） */
    private String form;
    /** 单据状态 */
    private String type;
    /** 审批流程Id */
    private String flowPlanId;
    /** 审批记录（JSON） List<FlowLog> */
    private String flowLog;
} 