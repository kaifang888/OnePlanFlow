package com.itkf.oneflowplan.serve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务DTO：子分支节点DTO，对应领域对象SubBranch。
 * 用于服务层与前端/接口的数据传输。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubBranchDTO extends FlowConfigNodeDTO {
    /** 条件 */
    private ConditionDTO condition;
    /** 名称 */
    private String name;
} 