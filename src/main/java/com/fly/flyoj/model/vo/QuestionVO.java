package com.fly.flyoj.model.vo;


import cn.hutool.json.JSONUtil;
import com.fly.flyoj.model.dto.question.JudgeConfig;
import com.fly.flyoj.model.entity.Question;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目视图
 */
@Data
public class QuestionVO implements Serializable {

    private final static Gson GSON = new Gson();

    private static final long serialVersionUID = 3507636304837042418L;

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 题目提交数
     */
    private Integer submitNum;

    /**
     * 题目通过数
     */
    private Integer acceptNum;


    /**
     * 判题配置(json对象)
     */
    private List<JudgeConfig> judgeConfig;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private UserVO userVO;


    /**
     * 包装类转对象
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tagList = questionVO.getTags();
        if (tagList != null) {
            question.setTags(JSONUtil.toJsonStr(tagList));
        }

        List<JudgeConfig> judgeConfigList = questionVO.getJudgeConfig();
        if (judgeConfigList != null) {
            question.setJudgeConfig(JSONUtil.toJsonStr(judgeConfigList));
        }
        return question;
    }

    /**
     * 对象转包装类
     *
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        List<String> tagList = JSONUtil.toList(question.getTags(), String.class);

        if (tagList != null) {
            questionVO.setTags(tagList);
        }

        List<JudgeConfig> judgeConfigList = JSONUtil.toList(question.getJudgeConfig(), JudgeConfig.class);
        if (judgeConfigList != null) {
            questionVO.setJudgeConfig(judgeConfigList);
        }
        return questionVO;
    }
}
