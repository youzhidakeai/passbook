package com.imooc.passbook.service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-11
 * Time: 下午2:31
 */

import com.imooc.passbook.vo.Pass;
import com.imooc.passbook.vo.Response;

/**
 * 获取用户个人优惠券信息
 */
public interface IUserPassService {

    /**
     * 获取用户个人优惠券信息，即我的优惠券功能实现
     * @param userId 用户ID
     * @return {@link Response}
     * @throws Exception
     */
    Response getUserPassInfo(Long userId) throws Exception;

    /**
     * 获取用户已经消费的优惠券 即已经使用的优惠券功能实现
     * @param userId 用户ID
     * @return {@link Response}
     * @throws Exception
     */
    Response getUserUsedPassInfo(Long userId) throws Exception;

    /**
     * 获取用户所有的优惠券
     * @param userId 用户id
     * @return {@link Response}
     * @throws Exception
     */
    Response getUserAllPassInfo(Long userId) throws Exception;

    /**
     * 用户使用优惠券
     * @param pass {@link Pass}
     * @return {@link Response}
     */
    Response userUsePass(Pass pass);
}
