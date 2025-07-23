package com.itkf.oneflowplan.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 数据对象：审批流实例流程表，对应数据库表flow_plan。
 * 用于数据库表映射，通常与数据库表结构一一对应。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("flow_plan")
public class FlowPlanDO {
    /** 流程引擎主键 */
    private String id;
    /** 流程引擎前序节点 */
    private String preId;
    /** 流程引擎执行节点 */
    private String taskId;
    /** 流程引擎后续节点 */
    private String nextId;
    /** 流程引擎使用的审批流模版Id */
    private String flowPlanConfigId;
    /** 流程引擎处理的节点的链表（JSON） List<FlowPlanNodeDTO> */
    private String flowNodes;
} 