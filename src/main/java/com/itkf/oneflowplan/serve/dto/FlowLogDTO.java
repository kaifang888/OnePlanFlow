package com.itkf.oneflowplan.serve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 业务DTO：审批记录DTO，对应领域对象FlowLog。
 * 用于服务层与前端/接口的数据传输。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowLogDTO {
    /** 节点ID */
    private String nodeId;
    /** 审批人ID */
    private String approverId;
    /** 审批动作 */
    private String action;
    /** 审批意见 */
    private String comment;
    /** 审批时间 */
    private Date timestamp;
} 