package com.itkf.oneflowplan.control.controller;

import com.itkf.oneflowplan.serve.executor.FlowPlanConfigRequest;
import com.itkf.oneflowplan.serve.executor.Result;
import com.itkf.oneflowplan.serve.service.FlowPlanConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 审批流模版Controller
 */
@RestController
@RequestMapping("/api/rest/flowPlanConfig")
public class FlowPlanConfigController {

    @Autowired
    private FlowPlanConfigService flowPlanConfigService;

    /**
     * 创建审批流模版
     * @param staffId 员工ID
     * @param request 创建参数
     * @return 模版ID
     */
    @PostMapping("/create")
    public Result<String> createFlowPlanConfig(@RequestParam String staffId, @RequestBody FlowPlanConfigRequest request) {
        return flowPlanConfigService.createFlowPlanConfig(staffId, request);
    }
} 