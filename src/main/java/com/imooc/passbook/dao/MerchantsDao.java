package com.imooc.passbook.dao;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-10
 * Time: 下午4:35
 */

import com.imooc.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Merchants Dao 接口
 */
public interface MerchantsDao extends JpaRepository<Merchants,Integer> {

    //根据id获取商户对象
    Merchants findById(Integer id);

    //根据商户名称获取商户对象
    Merchants findByName(String name);

    //根据商户 ids 获取商户对象
    List<Merchants> findByIdIn(List<Integer> ids);


}
