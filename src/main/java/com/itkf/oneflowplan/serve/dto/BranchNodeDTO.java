package com.itkf.oneflowplan.serve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class BranchNodeDTO extends FlowConfigNodeDTO {
    /**
     * 分支列表
     */
    public final List<SubBranchDTO> branches;

    public BranchNodeDTO(String id, FlowConfigNodeDTO next, List<SubBranchDTO> branches) {
        super(id, next);
        this.branches = branches;
    }
}
