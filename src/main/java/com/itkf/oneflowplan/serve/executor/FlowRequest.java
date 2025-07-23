package com.itkf.oneflowplan.serve.executor;

import com.itkf.oneflowplan.domain.entity.FlowDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单据创建参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowRequest {
    /** 单据数据 */
    private String form;
    /** 审批流模版Id */
    private String flowPlanConfigId;
} 