package com.imooc.passbook.constant;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-10
 * Time: 下午2:21
 */

/**
 * 优惠券状态
 */
public enum PassStatus {

    UNUSED(1,"未被使用的"),
    USED(2,"已经被使用的"),
    ALL(3,"全部领取的");

    private Integer code;

    private String desc;

    PassStatus(Integer code,String desc){
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
