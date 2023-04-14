package com.canteen.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.canteen.common.annotation.Excel;
import com.canteen.common.core.domain.BaseEntity;

/**
 * 留言对象 msg
 * 
 * @author xx
 * @date 2023-04-09
 */
public class Msg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 留言id */
    private Long msgId;

    /** 商家名称 */
    @Excel(name = "商家名称")
    private String shopName;

    /** 商家ID */
    private Long businessId;

    /** 用户ID */
    private Long userId;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 留言信息 */
    @Excel(name = "留言信息")
    private String message;

    public void setMsgId(Long msgId) 
    {
        this.msgId = msgId;
    }

    public Long getMsgId() 
    {
        return msgId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setBusinessId(Long businessId)
    {
        this.businessId = businessId;
    }

    public Long getBusinessId() 
    {
        return businessId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("msgId", getMsgId())
            .append("shopName", getShopName())
            .append("businessId", getBusinessId())
            .append("createTime", getCreateTime())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("message", getMessage())
            .toString();
    }
}
