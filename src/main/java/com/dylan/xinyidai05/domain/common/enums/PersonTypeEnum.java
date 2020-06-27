package com.dylan.xinyidai05.domain.common.enums;

public enum PersonTypeEnum {
    //
    Agent_TYPE("00","代理人"),
    BAILEE_TYPE("02","受托人"),
    Applicant_TYPE("03","投保人"),
    Insured_TYPE("04","被保人"),
    Beneficiary_TYPE("05","受益人"),
    OLD_PERSON_TYPE("0","客户认证标记为老客户"),
    NEW_PERSON_TYPE("1","客户认证标记为新客户"),
    SIMILAR_PERSON_TYPE("2","客户认证标记为疑似客户"),
    REPEAT_CERTIFICATION("3","同一客户正在认证"),
    UNABLE_TO_GET_NEW_CUSTOMER_NUMBER("4","无法获取到新客户号"),
    CUSTOMER_INFO_FAILED_TO_LAND_IN_THE_OLD_CORE("5","客户信息落地老核心失败"),
    CUSTOMER_INFO_LANDING_NEW_GENERATION_FAILURE("6","客户信息落地新一代失败"),
    OCCUPATION_DISCLOSURE("06","被保人职业告知信息"),
    HEALTH_DISCLOSURE("07","被保人健康告知信息");


    // 序列号
    private String code;
    // 描述
    private String desc;

    private PersonTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }


    public static PersonTypeEnum getByErrorCode(String code){
        for(PersonTypeEnum codeEnum : values()){
            if(codeEnum.code.equals(code)){
                return codeEnum;
            }
        }
        return null;
    }

    public static String getByMessage(String code){
        for(PersonTypeEnum codeEnum : values()){
            if(codeEnum.code.equals(code)){
                return codeEnum.getMessage();
            }
        }
        return null;
    }


    public String getCode() {
        return code;
    }
    public String getMessage() {
        return desc;
    }

}
