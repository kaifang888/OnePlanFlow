package com.itkf.oneflowplan.serve.dto;

import com.fasterxml.jackson.databind.JsonNode;

public class EbotDTO extends FlowConfigNodeDTO{
    /** 条件 */
    private ConditionDTO condition;
    /**后续动作 */
    private JsonNode ebotConfig;
}
