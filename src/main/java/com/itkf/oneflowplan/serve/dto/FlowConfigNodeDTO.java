package com.itkf.oneflowplan.serve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;

/**
 * 业务DTO：审批流模板节点DTO，对应领域对象FlowConfigNode。
 * 用于服务层与前端/接口的数据传输。
 */
@Data
@NoArgsConstructor
public abstract class FlowConfigNodeDTO {
    /** 节点ID */
    private String id;
    /** 节点类型（如EBOT、CONDITION、SIMPLE等） */
    private String type;
    /** 节点名称 */
    private String name;
    /** 下一个节点 */
    public FlowConfigNodeDTO next;

    public FlowConfigNodeDTO(String id, FlowConfigNodeDTO next) {
        this.id = id;
        this.next = next;
    }

    public FlowConfigNodeDTO map(Function<FlowConfigNodeDTO, FlowConfigNodeDTO> nodeFunc) {
        if (this instanceof BranchNodeDTO) {
            BranchNodeDTO node = (BranchNodeDTO) nodeFunc.apply(this);
            node.branches.forEach(e -> {
                FlowConfigNodeDTO subBranchNode = nodeFunc.apply(e);
                if (subBranchNode.next != null) {
                    subBranchNode.next = subBranchNode.next.map(nodeFunc);
                }
            });

            if (node.next != null) {
                node.next = node.next.map(nodeFunc);
            }
            return node;
        } else {
            FlowConfigNodeDTO start = nodeFunc.apply(this);
            if (start.next != null) {
                start.next = start.next.map(nodeFunc);
            }
            return start;
        }
    }
}