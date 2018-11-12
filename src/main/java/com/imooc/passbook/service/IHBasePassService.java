package com.imooc.passbook.service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-10
 * Time: 下午9:27
 */

import com.imooc.passbook.vo.PassTemplate;

/**
 * Pass HBase 服务
 */
public interface IHBasePassService {

    /**
     * 将PassTemplate 写入HBase中
     * @param passTemplate {@link PassTemplate}
     * @return true/false
     */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);

}
