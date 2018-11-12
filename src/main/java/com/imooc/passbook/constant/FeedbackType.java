package com.imooc.passbook.constant;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-10
 * Time: 下午2:25
 */

/**
 * 评论类型枚举
 */
public enum  FeedbackType {

    PASS(1,"针对优惠券的评论"),
    APP(2,"针对卡包APP的评论");

    //评论类型编码
    private Integer code;

    //评论类型描述
    private String desc;

    FeedbackType(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }
}
