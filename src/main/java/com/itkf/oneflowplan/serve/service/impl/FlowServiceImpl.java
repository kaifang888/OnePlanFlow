package com.itkf.oneflowplan.serve.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.itkf.oneflowplan.domain.entity.FlowDO;
import com.itkf.oneflowplan.domain.entity.FlowPlanConfigDO;
import com.itkf.oneflowplan.domain.entity.FlowPlanDO;
import com.itkf.oneflowplan.serve.dto.*;
import com.itkf.oneflowplan.serve.executor.FlowRequest;
import com.itkf.oneflowplan.serve.executor.Result;
import com.itkf.oneflowplan.serve.service.FlowService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 单据服务实现
 */
@Service
public class FlowServiceImpl implements FlowService {
    @Override
    public Result<String> save2CommitFlow(String staffId, FlowRequest request) {
        // 1. 校验表单完整性
        if (request == null || request.getForm() == null || request.getFlowPlanConfigId() == null) {
            return Result.fail("400", "表单参数不完整");
        }
        FlowDTO form = JSONObject.parseObject(request.getForm(),FlowDTO.class);
        if (form.getForm() == null || form.getForm().isEmpty()) {
            return Result.fail("400", "单据数据不能为空");
        }
        // 2. 查询审批流模板（伪代码）
        FlowPlanConfigDO config = getConfigById(request.getFlowPlanConfigId());
        if (config == null) {
            return Result.fail("404", "审批流模板不存在");
        }
        // 3. 剪枝生成流程节点链表（伪代码）
        List<FlowNodeDTO> nodes = pruneNodes(config.getStart(), form.getForm());
        if (CollectionUtils.isEmpty(nodes)) {
            return Result.fail("422", "流程剪枝失败");
        }
        // 4. 生成流程实例
        FlowPlanDO plan = new FlowPlanDO();
        plan.setId(UUID.randomUUID().toString());
        plan.setFlowPlanConfigId(config.getId());
        plan.setFlowNodes(JSONObject.toJSONString(nodes));
        // 5. 持久化流程实例（伪代码）
        savePlan(plan);
        // 6. 生成单据
        FlowDO flow = new FlowDO();
        flow.setId(UUID.randomUUID().toString());
        flow.setOwnerId(staffId);
        flow.setForm(JSONObject.toJSONString(form.getForm()));
        flow.setType("flowing"); // 初始为待审批
        flow.setFlowPlanId(plan.getId());
        flow.setFlowLog(JSONArray.toJSONString(new ArrayList<>()));
        // 7. 持久化单据（伪代码）
        saveFlow(flow);
        // 8. 记录日志（伪代码）
        log("提交单据", staffId, flow.getId(), plan.getId());
        // 9. 返回单据ID
        return Result.ok(flow.getId());
    }



    // 伪实现：查询审批流模板
    private FlowPlanConfigDO getConfigById(String id) {
        // TODO: 查询数据库
        return null;
    }

    // 伪实现：流程节点剪枝
    private List<FlowNodeDTO> pruneNodes(String start, Map<String, Object> formData) {
        // TODO: 剪枝算法实现
        FlowConfigNodeDTO startNode = JSONObject.parseObject(start, FlowConfigNodeDTO.class);
        return new ArrayList<>();
    }

    // 伪实现：持久化流程实例
    private void savePlan(FlowPlanDO plan) {
        // TODO: 持久化到数据库
    }

    // 伪实现：持久化单据
    private void saveFlow(FlowDO flow) {
        // TODO: 持久化到数据库
    }

    // 伪实现：记录日志
    private void log(String action, String staffId, String flowId, String planId) {
        // TODO: 记录操作日志
    }



} 