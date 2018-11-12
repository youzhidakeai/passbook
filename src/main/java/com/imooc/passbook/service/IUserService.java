package com.imooc.passbook.service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-11
 * Time: 上午11:05
 */

import com.imooc.passbook.vo.Response;
import com.imooc.passbook.vo.User;

/**
 * 用户服务：创建USer服务
 */
public interface IUserService {

    /**
     * 创建用户
     * @param user {@link User}
     * @return     {@link Response}
     * @throws Exception
     */
    Response createUser(User user) throws Exception;
}
