package com.canteen.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.canteen.common.annotation.Excel;
import com.canteen.common.core.domain.BaseEntity;

/**
 * 菜品评分信息对象 food_score
 * 
 * @author xx
 * @date 2023-04-14
 */
public class FoodScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long ID;

    /** 菜品ID */
    private Long foodId;

    /** 菜品名称 */
    @Excel(name = "菜品名称")
    private String foodName;

    /** 店铺名称 */
    @Excel(name = "店铺名称")
    private String shopName;

    /** 菜色评分 */
    @Excel(name = "菜色评分")
    private String csScore;

    /** 菜品评分 */
    @Excel(name = "菜品评分")
    private String cpScore;

    /** 价格评分 */
    @Excel(name = "价格评分")
    private String jgScore;

    /** 卫生评分 */
    @Excel(name = "卫生评分")
    private String wsScore;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    public void setID(Long ID) 
    {
        this.ID = ID;
    }

    public Long getID() 
    {
        return ID;
    }
    public void setFoodId(Long foodId) 
    {
        this.foodId = foodId;
    }

    public Long getFoodId() 
    {
        return foodId;
    }
    public void setFoodName(String foodName) 
    {
        this.foodName = foodName;
    }

    public String getFoodName() 
    {
        return foodName;
    }
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setCsScore(String csScore) 
    {
        this.csScore = csScore;
    }

    public String getCsScore() 
    {
        return csScore;
    }
    public void setCpScore(String cpScore) 
    {
        this.cpScore = cpScore;
    }

    public String getCpScore() 
    {
        return cpScore;
    }
    public void setJgScore(String jgScore) 
    {
        this.jgScore = jgScore;
    }

    public String getJgScore() 
    {
        return jgScore;
    }
    public void setWsScore(String wsScore) 
    {
        this.wsScore = wsScore;
    }

    public String getWsScore() 
    {
        return wsScore;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getID())
            .append("foodId", getFoodId())
            .append("foodName", getFoodName())
            .append("shopName", getShopName())
            .append("csScore", getCsScore())
            .append("cpScore", getCpScore())
            .append("jgScore", getJgScore())
            .append("wsScore", getWsScore())
            .append("userName", getUserName())
            .toString();
    }
}
