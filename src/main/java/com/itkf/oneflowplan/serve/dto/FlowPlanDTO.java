package com.itkf.oneflowplan.serve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 业务DTO：流程实例DTO，对应领域对象FlowPlan。
 * 用于服务层与前端/接口的数据传输。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowPlanDTO {
    /** 流程引擎主键 */
    private String id;
    /** 前序节点 */
    private String preId;
    /** 执行节点 */
    private String taskId;
    /** 后续节点 */
    private String nextId;
    /** 使用的审批流模版Id */
    private String flowPlanConfigId;
    /** 节点链表 */
    private List<FlowNodeDTO> flowNodes;
} 