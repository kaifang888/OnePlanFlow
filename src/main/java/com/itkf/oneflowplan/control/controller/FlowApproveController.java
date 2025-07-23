package com.itkf.oneflowplan.control.controller;

import com.itkf.oneflowplan.serve.executor.ApproveFlowRequest;
import com.itkf.oneflowplan.serve.executor.Result;
import com.itkf.oneflowplan.serve.service.FlowApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 审批推进Controller
 */
@RestController
@RequestMapping("/api/rest/flow/approve")
public class FlowApproveController {

    @Autowired
    private FlowApproveService flowApproveService;

    /**
     * 审批推进
     * @param request 审批参数
     * @return 操作结果
     */
    @PostMapping("")
    public Result<String> approveFlow(@RequestBody ApproveFlowRequest request) {
        return flowApproveService.approveFlow(request);
    }
} 