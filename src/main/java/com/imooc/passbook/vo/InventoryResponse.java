package com.imooc.passbook.vo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-11
 * Time: 下午12:33
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 库存请求响应(商户在平台上投放的可用的优惠券)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {

    //用户ID
    private Long userId;

    //优惠券模板信息（用户没有领取的优惠券信息）
    private List<PassTemplateInfo> passTemplateInfos;


}
