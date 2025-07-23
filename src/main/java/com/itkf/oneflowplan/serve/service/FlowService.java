package com.itkf.oneflowplan.serve.service;

import com.itkf.oneflowplan.serve.executor.FlowRequest;
import com.itkf.oneflowplan.serve.executor.Result;

/**
 * 单据服务接口
 */
public interface FlowService {
    /**
     * 创建单据并提交
     * @param staffId 员工ID
     * @param request 创建参数
     * @return 单据ID
     */
    Result<String> save2CommitFlow(String staffId, FlowRequest request);

} 