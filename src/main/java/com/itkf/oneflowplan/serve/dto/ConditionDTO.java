package com.itkf.oneflowplan.serve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务DTO：条件DTO，对应领域对象Condition。
 * 用于服务层与前端/接口的数据传输。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConditionDTO {
    /** 条件表达式 */
    private String expression;
    /** 条件描述 */
    private String description;
} 