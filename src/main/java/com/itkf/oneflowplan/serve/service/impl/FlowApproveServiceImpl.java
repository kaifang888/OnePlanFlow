package com.itkf.oneflowplan.serve.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.itkf.oneflowplan.domain.entity.FlowDO;
import com.itkf.oneflowplan.domain.entity.FlowPlanDO;
import com.itkf.oneflowplan.serve.dto.FlowDTO;
import com.itkf.oneflowplan.serve.dto.FlowLogDTO;
import com.itkf.oneflowplan.serve.dto.FlowNodeDTO;
import com.itkf.oneflowplan.serve.dto.FlowPlanDTO;
import com.itkf.oneflowplan.serve.executor.ApproveFlowRequest;
import com.itkf.oneflowplan.serve.executor.Result;
import com.itkf.oneflowplan.serve.service.FlowApproveService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 审批推进服务实现
 */
@Service
public class FlowApproveServiceImpl implements FlowApproveService {
    @Override
    public Result<String> approveFlow(ApproveFlowRequest request) {
        // 1. 查询单据和流程实例（伪代码）
        FlowDO flow = getFlowById(request.getFlowId());
        FlowPlanDO plan = getPlanById(request.getFlowPlanId());
        if (flow == null || plan == null) {
            return Result.fail("404", "单据或流程实例不存在");
        }
        FlowDTO flowDTO =convert(flow);
        // 2. 获取当前节点（伪代码）
        List<FlowNodeDTO> nodes = JSONArray.parseArray(plan.getFlowNodes(), FlowNodeDTO.class);
        FlowNodeDTO node = nodes.stream().filter(n -> n.getId().equals(request.getNodeId())).findFirst().orElse(null);
        if (node == null) {
            return Result.fail("404", "节点不存在");
        }
        // 3. 校验节点是否可操作、动作是否合法
        if (!canApprove(node, request.getAction())) {
            log(flowDTO, plan, node, request, "审批失败");
            return Result.fail("403", "节点不可操作或动作非法");
        }
        // 4. 更新节点状态
        node.setHasApproved(true);
        node.setEndTime(new Date());
        node.setApproverId(request.getStaffId());
        // 5. 推进流程指针（伪代码）
        boolean finished = moveToNextNode(plan, nodes, node, request.getAction());
        // 6. 更新流程和单据状态
        if (finished) {
            flowDTO.setType("success");
        } else if ("rejected".equals(request.getAction())) {
            flowDTO.setType("rejected");
        }
        // 7. 记录审批日志
        log(flowDTO, plan, node, request, request.getAction());
        // 8. 持久化（伪实现）
        savePlan(plan);
        saveFlow(flowDTO);
        // 9. 返回结果
        return Result.ok("审批操作成功");
    }

    private FlowDTO convert(FlowDO flow) {
        List<FlowLogDTO> flowLog = JSONArray.parseArray(flow.getFlowLog(), FlowLogDTO.class);
        TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {};
        Map<String, Object> form = JSON.parseObject(flow.getForm(), typeRef);
        return null;
    }


    // 伪实现：节点是否可操作
    private boolean canApprove(FlowNodeDTO node, String action) {
        // TODO: 校验节点状态和动作是否合法
        return !node.isHasApproved() && ("agree".equals(action) || "rejected".equals(action));
    }

    // 伪实现：推进流程指针
    private boolean moveToNextNode(FlowPlanDO plan, List<FlowNodeDTO> nodes, FlowNodeDTO node, String action) {
        // TODO: 推进流程指针，判断流程是否结束
        return nodes.stream().allMatch(FlowNodeDTO::isHasApproved);
    }

    // 伪实现：查询单据
    private FlowDO getFlowById(String flowId) {
        // TODO: 查询数据库
        return null;
    }

    // 伪实现：查询流程实例
    private FlowPlanDO getPlanById(String planId) {
        // TODO: 查询数据库
        return null;
    }

    // 伪实现：持久化
    private void savePlan(FlowPlanDO plan) {
        // TODO: 持久化到数据库
    }

    private void saveFlow(FlowDTO flow) {
        // TODO: 持久化到数据库
    }

    // 伪实现：记录日志
    private void log(FlowDTO flow, FlowPlanDO plan, FlowNodeDTO node, ApproveFlowRequest request, String action) {
        // TODO: 记录操作日志
    }
} 