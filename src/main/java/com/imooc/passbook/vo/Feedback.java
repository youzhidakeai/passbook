package com.imooc.passbook.vo;

import com.google.common.base.Enums;
import com.imooc.passbook.constant.FeedbackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-10
 * Time: 下午6:11
 */

/**
 * 用户评论
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    //用户 id
    private Long userId;

    //评论类型
    private String type;

    //PassTemplate RowKey, 如果是 app 类型的评论, 则没有
    private String templateId;

    //评论内容
    private String comment;

    public boolean validate() {

        FeedbackType feedbackType = Enums.getIfPresent(
                FeedbackType.class, this.type.toUpperCase()
        ).orNull();

        return !(null == feedbackType || null == comment);
    }
}
