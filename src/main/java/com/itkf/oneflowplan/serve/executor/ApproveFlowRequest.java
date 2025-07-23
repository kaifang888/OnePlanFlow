package com.itkf.oneflowplan.serve.executor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 审批推进参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApproveFlowRequest {
    /** 员工ID */
    private String staffId;
    /** 单据ID */
    private String flowId;
    /** 流程实例ID */
    private String flowPlanId;
    /** 节点ID */
    private String nodeId;
    /** 审批动作（同意/驳回/拒绝） */
    private String action;
    /** 审批意见 */
    private String comment;
} 