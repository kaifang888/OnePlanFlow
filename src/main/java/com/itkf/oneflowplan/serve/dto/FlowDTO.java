package com.itkf.oneflowplan.serve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 业务DTO：单据DTO，对应领域对象Flow。
 * 用于服务层与前端/接口的数据传输。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowDTO {
    /** 提交人Id */
    private String ownerId;
    /** 单据数据 */
    private Map<String, Object> form;
    /** 审批流程Id */
    private String flowPlanId;
    /** 单据状态 */
    private String type;
    /** 审批记录 */
    private List<FlowLogDTO> flowLog;
} 