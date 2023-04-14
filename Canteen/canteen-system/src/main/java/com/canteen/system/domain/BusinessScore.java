package com.canteen.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.canteen.common.annotation.Excel;
import com.canteen.common.core.domain.BaseEntity;

/**
 * 食堂评分信息对象 business_score
 * 
 * @author xx
 * @date 2023-04-10
 */
public class BusinessScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long ID;

    /** 店铺ID */
    private Long businessId;

    /** 店铺名称 */
    @Excel(name = "店铺名称")
    private String businessName;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    /** 用户ID */
    private Long userId;

    /** 食堂服务分 */
    @Excel(name = "食堂服务分")
    private String fwScore;

    /** 食堂卫生分 */
    @Excel(name = "食堂卫生分")
    private String wsScore;

    /** 食堂仪容仪表分 */
    @Excel(name = "食堂仪容仪表分")
    private String yrybScore;

    /** 食堂菜品陈列分 */
    @Excel(name = "食堂菜品陈列分")
    private String clScore;

    public void setID(Long ID) 
    {
        this.ID = ID;
    }

    public Long getID() 
    {
        return ID;
    }
    public void setBusinessId(Long businessId) 
    {
        this.businessId = businessId;
    }

    public Long getBusinessId() 
    {
        return businessId;
    }
    public void setBusinessName(String businessName) 
    {
        this.businessName = businessName;
    }

    public String getBusinessName() 
    {
        return businessName;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setFwScore(String fwScore) 
    {
        this.fwScore = fwScore;
    }

    public String getFwScore() 
    {
        return fwScore;
    }
    public void setWsScore(String wsScore) 
    {
        this.wsScore = wsScore;
    }

    public String getWsScore() 
    {
        return wsScore;
    }
    public void setYrybScore(String yrybScore) 
    {
        this.yrybScore = yrybScore;
    }

    public String getYrybScore() 
    {
        return yrybScore;
    }
    public void setClScore(String clScore) 
    {
        this.clScore = clScore;
    }

    public String getClScore() 
    {
        return clScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getID())
            .append("businessId", getBusinessId())
            .append("businessName", getBusinessName())
            .append("userName", getUserName())
            .append("userId", getUserId())
            .append("fwScore", getFwScore())
            .append("wsScore", getWsScore())
            .append("yrybScore", getYrybScore())
            .append("clScore", getClScore())
            .append("createTime", getCreateTime())
            .toString();
    }
}
