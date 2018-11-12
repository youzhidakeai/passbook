package com.imooc.passbook.entity;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-10
 * Time: 下午4:27
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 商户对象模型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants {

    //商户ID
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private Integer id;

    //商户名称
    @Basic
    @Column(name = "name",nullable = false,unique = true)
    private String name;

    //商户logo
    @Basic
    @Column(name = "logo_url",nullable = false)
    private String logoUrl;

    //商户营业执照
    @Basic
    @Column(name = "nusiness_license_url",nullable = false)
    private String businessLicenseUrl;

    //商户联系电话
    @Basic
    @Column(name = "phone",nullable = false)
    private String phone;

    //商户地址
    @Basic
    @Column(name = "address",nullable = false)
    private String address;

    //商户是否通过审核
    @Basic
    @Column(name = "is_audit",nullable = false)
    private Boolean isAudit;

}
