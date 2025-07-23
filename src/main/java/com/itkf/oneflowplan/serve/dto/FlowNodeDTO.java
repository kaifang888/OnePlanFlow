package com.itkf.oneflowplan.serve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 业务DTO：流程节点DTO，对应领域对象FlowNode。
 * 用于服务层与前端/接口的数据传输。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowNodeDTO {
    /** 节点ID */
    private String id;
    /** 节点类型 */
    private String type;
    /** 节点名称 */
    private String name;
    /** 是否已审批 */
    private boolean hasApproved;
    /** 审批人ID */
    private String approverId;
    /** 节点开始时间 */
    private Date startTime;
    /** 节点结束时间 */
    private Date endTime;
    // 其他节点特有属性
} 