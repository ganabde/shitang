package com.canteen.common.core.domain.model;

/**
 * 用户注册对象
 * 
 * @author ruoyi
 */

public class RegisterBody extends LoginBody
{
    private String phonenumber;
    private String nickName;
    private String businessImage;
    private Long deptIds;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBusinessImage() {
        return businessImage;
    }

    public void setBusinessImage(String businessImage) {
        this.businessImage = businessImage;
    }

    public Long getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Long deptIds) {
        this.deptIds = deptIds;
    }
}
