package com.imooc.passbook.vo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-11
 * Time: 下午12:39
 */

import com.imooc.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户领取的优惠券信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassInfo {

    //优惠券
    private Pass pass;

    //优惠券模板
    private PassTemplate passTemplate;

    //优惠券对应的商户信息
    private Merchants merchants;
}
