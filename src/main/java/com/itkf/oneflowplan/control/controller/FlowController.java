package com.itkf.oneflowplan.control.controller;

import com.itkf.oneflowplan.serve.executor.FlowRequest;
import com.itkf.oneflowplan.serve.executor.Result;
import com.itkf.oneflowplan.serve.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 单据Controller
 */
@RestController
@RequestMapping("/api/rest/flow")
public class FlowController {

    @Autowired
    private FlowService flowService;

    /**
     * 创建单据
     * @param staffId 员工ID
     * @param request 创建参数
     * @return 单据ID
     */
    @PostMapping("/create2commit")
    public Result<String> saveFlow(@RequestParam String staffId, @RequestBody FlowRequest request) {
        return flowService.save2CommitFlow(staffId, request);
    }



} 