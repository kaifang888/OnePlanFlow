package com.itkf.oneflowplan.serve.service;

import com.itkf.oneflowplan.serve.executor.FlowPlanConfigRequest;
import com.itkf.oneflowplan.serve.executor.Result;

/**
 * 审批流模版服务接口
 */
public interface FlowPlanConfigService {
    /**
     * 创建审批流模版
     * @param staffId 员工ID
     * @param request 创建参数
     * @return 模版ID
     */
    Result<String> createFlowPlanConfig(String staffId, FlowPlanConfigRequest request);
} 