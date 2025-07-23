package com.itkf.oneflowplan.serve.executor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /** 是否成功 */
    private boolean success;
    /** 结果码 */
    private String code;
    /** 结果描述 */
    private String message;
    /** 返回数据 */
    private T data;

    public static <T> Result<T> ok(T data) {
        return new Result<>(true, "200", "操作成功", data);
    }

    public static <T> Result<T> fail(String code, String message) {
        return new Result<>(false, code, message, null);
    }
} 