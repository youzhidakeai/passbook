package com.imooc.passbook.vo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-10
 * Time: 下午6:01
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 投放的优惠券对象定义
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {

    //所属商户 ID
    private Integer id;

    //优惠券标题
    private String title;

    //优惠券摘要
    private String summary;

    //优惠券详细信息
    private String desc;

    //最大个数限制
    private Long limit;

    // 优惠券是否用于 token 用于商户核销
    private Boolean hasToken;

    //用户券背景色
    private Integer background;

    //优惠券开始时间
    private Date startTime;

    //优惠券结束时间
    private Date endTime;
}
