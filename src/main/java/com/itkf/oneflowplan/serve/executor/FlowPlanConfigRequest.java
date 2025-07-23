package com.itkf.oneflowplan.serve.executor;

import com.itkf.oneflowplan.serve.dto.FlowConfigNodeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 审批流模版创建参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowPlanConfigRequest {
    /** 审批流名称 */
    private String name;
    /** 审批流的节点列表 */
    private String start;
    /** 最后一次的编辑者 */
    private String editor;
    /** 审批流状态 */
    private String state;
} 