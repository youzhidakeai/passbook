package com.imooc.passbook.service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-11
 * Time: 下午2:22
 */

import com.imooc.passbook.vo.Response;

/**
 * 获取库存信息，只返回用户没有领取的，即优惠券库存功能
 */
public interface IInventoryService  {

    /**
     * 获取库存信息
     * @param userId 用户id
     * @return {@link Response}
     */
    Response getInventoryInfo(Long userId) throws Exception;
}
