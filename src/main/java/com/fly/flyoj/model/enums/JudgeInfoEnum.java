package com.fly.flyoj.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 判题信息枚举
 */
public enum JudgeInfoEnum {

    ACCEPT("成功", "Accepted"),
    WRONG_ANSWER("答案错误", "Wrong Answer"),
    TIME_LIMIT_EXCEED("超时", "Time Limit Exceeded"),
    MEMORY_LIMIT_EXCEED("内存超限", "Memory Limit Exceeded"),
    RUNTIME_ERROR("运行时错误", "Runtime Error"),
    Presentation("展示错误", "Presentation Error"),
    OUTPUT_LIMIT_EXCEED("输出超限", "Output Limit Exceeded"),
    WAITING("等待", "Waiting"),
    DANGEROUS_OPERATION("危险操作", "Dangerous operation"),
    SYSTEM_ERROR("系统错误", "System Error"),
    COMPILE_ERROR("编译错误", "Compile Error"),
    UNKNOWN("未知", "Unknown");

    private final String text;

    private final String value;

    JudgeInfoEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoEnum anEnum : JudgeInfoEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
