package com.bojin.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/1.
 */
@Data
@Entity
@Table(name = "person")
public class Person {

    /**
     * 状态：edit编辑状态，commit已提交保存状态
     */
    private enum Status{
        edit,commit;
    }
    /**
     *id
     */
    @Id
    @Column(name = "ID",nullable = false,unique = true)
    private Integer id;
    /**
     * 状态
     */
    @Column(name = "STATUS",nullable = false)
    private Status status;
    /**
     * 身份证号
     */
    @Column(name = "ID_NUMBER",nullable = false)
    private String idNumber;
    /**
     * 姓名
     */
    @Column(name = "NAME",nullable = false)
    private String NAME;
    /**
     * 人员类别
     */
    @Column(name = "PERSON_TYPE",nullable = false)
    private Integer personType;
    /**
     * 租赁面积
     */
    @Column(name = "RENTAL_AREA",nullable = false)
    private BigDecimal rentalArea;
    /**
     * 补贴标准
     */
    @Column(name = "SUBSIDY_STANDARD")
    private Integer subsidyStandard;
    /**
     * 创业方式
     */
    @Column(name = "STARTUP_WAY",nullable = false)
    private Integer startupWay;
    /**
     * 失业登记号
     */
    @Column(name = "UNEMPLOYMENT_CODE")
    private String unemploymentCode;
    /**
     * 失业登记有效时间起
     */
    @Column(name = "UNEMPLOYMENT_START")
    private Date unemploymentStart;
    /**
     * 失业登记有效时间止
     */
    @Column(name = "UNEMPLOYMENT_END")
    private Date unemploymentEnd;
    /**
     * 进驻基地名称
     */
    @Column(name = "BASE_NAME")
    private String baseName;
    /**
     * 进驻基地时间
     */
    @Column(name = "BASE_TIME")
    private Date baseTime;
    /**
     * 补贴金额
     */
    @Column(name = "SUBSIDY")
    private BigDecimal subsidy;
    /**
     * 营业执照编号
     */
    @Column(name = "BUSINESS_LICENSE_CODE")
    private String businessLicenseCode;
    /**
     * 营业执照领取时间
     */
    @Column(name = "RECEIVE_TIME")
    private Date receiveTime;
    /**
     * 营业执照附件
     */
    @Column(name = "BUSINESS_LICENSE")
    private String businessLicense;
    /**
     * 毕业院校
     */
    @Column(name = "GRADUATE_SCHOOL")
    private String graduateSchool;
    /**
     * 毕业时间
     */
    @Column(name = "GRADUATION_DATE")
    private Date graduationDate;
    /**
     *毕业证书附件
     */
    @Column(name = "DIPLOMA")
    private String diploma;
    /**
     * 结业证书编号
     */
    @Column(name = "CERTIFICATE_CODE")
    private String certificateCode;
    /**
     *结业时间
     */
    @Column(name = "CERTIFICATE_TIME")
    private Date certificateTime;
    /**
     * 结业证书附件
     */
    @Column(name = "CERTIFICATE")
    private String certificate;
    /**
     * 开户银行
     */
    @Column(name = "OPENING_BANK")
    private String openingBank;
    /**
     * 银行账号
     */
    @Column(name = "BANK_ACCOUNT")
    private String bankAccount;
    /**
     * 银行卡附件
     */
    @Column(name = "BANK_CARK")
    private String bankCark;
    /**
     * 户口本复印件
     */
    @Column(name = "HOUSEHOLD_REGISTER")
    private String householdRegister;
    /**
     * 身份证复印件
     */
    @Column(name = "IDENTITY_CARD")
    private String identityCard;
    /**
     * 场地租赁合同附件
     */
    @Column(name = "LEASE_CONTRACT")
    private String leaseContract;
    /**
     * 失业证附件
     */
    @Column(name = "UNEMPLOYMENT_CERTIFICATE")
    private String unemploymentCertificate;
    /**
     * 开户许可证附件
     */
    @Column(name = "OPENING_PERMIT")
    private String openingPermit;




}
