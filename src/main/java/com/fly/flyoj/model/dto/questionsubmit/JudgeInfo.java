package com.fly.flyoj.model.dto.questionsubmit;

import lombok.Data;

/**
 * 题目提交返回信息
 */
@Data
public class JudgeInfo {
    /**
     * 返回信息
     */
    private String message;
    /**
     * 时间大小
     */
    private Long time;

    /**
     * 空间大小
     */
    private Long memory;
}
