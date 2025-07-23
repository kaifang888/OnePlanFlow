package com.itkf.oneflowplan.serve.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.itkf.oneflowplan.domain.entity.FlowPlanConfigDO;
import com.itkf.oneflowplan.serve.dto.FlowConfigNodeDTO;
import com.itkf.oneflowplan.serve.executor.FlowPlanConfigRequest;
import com.itkf.oneflowplan.serve.executor.Result;
import com.itkf.oneflowplan.serve.service.FlowPlanConfigService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 审批流模版服务实现
 */

@Service
public class FlowPlanConfigServiceImpl implements FlowPlanConfigService {
    @Override
    public Result<String> createFlowPlanConfig(String staffId, FlowPlanConfigRequest request) {
        // 1. 校验参数完整性
        if (request == null || request.getName() == null || request.getStart().isEmpty() || request.getEditor() == null || request.getState() == null) {
            return Result.fail("400", "参数不完整");
        }
        // 2. 校验模板名称唯一性（伪代码，实际应查数据库）
        if (templateNameExists(request.getName())) {
            return Result.fail("409", "模板重名");
        }
        // 3. 校验节点结构（伪代码，实际应遍历start节点列表）
        FlowConfigNodeDTO start = validateNodes(request.getStart());

        List<FlowConfigNodeDTO> nodes = new ArrayList<>();
        // 4. 构建DO对象
        FlowPlanConfigDO configDO = FlowPlanConfigDO.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .start(request.getStart())
                .state(request.getState())
                .editorId(staffId)
                .build();
        // 5. 持久化（伪代码，实际应调用Mapper保存）
        save(configDO);
        // 6. 记录操作日志（伪代码）
        log("模板创建", staffId, configDO.getId(), configDO.getName());
        // 7. 返回新模板ID
        return Result.ok(configDO.getId());
    }

    // 伪实现：校验模板名称唯一性
    private boolean templateNameExists(String name) {
        // TODO: 查询数据库是否存在同名激活模板
        return false;
    }

    // 伪实现：校验节点结构
    private FlowConfigNodeDTO validateNodes(String start) {
        FlowConfigNodeDTO startNode = JSONObject.parseObject(start, FlowConfigNodeDTO.class);
        // TODO: 遍历节点列表，校验节点类型、分支、条件等
        // startNode.map();
        return null;
    }

    // 伪实现：持久化
    private void save(FlowPlanConfigDO configDO) {
        // TODO: 持久化到数据库
    }

    // 伪实现：记录日志
    private void log(String action, String staffId, String id, String name) {
        // TODO: 记录操作日志
    }
} 