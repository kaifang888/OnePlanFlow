package com.itkf.oneflowplan.serve.service;

import com.itkf.oneflowplan.serve.executor.ApproveFlowRequest;
import com.itkf.oneflowplan.serve.executor.Result;

/**
 * 审批推进服务接口
 */
public interface FlowApproveService {
    /**
     * 审批推进
     * @param request 审批参数
     * @return 操作结果
     */
    Result<String> approveFlow(ApproveFlowRequest request);
} 