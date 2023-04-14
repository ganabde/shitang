package com.canteen.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.canteen.common.annotation.Excel;
import com.canteen.common.core.domain.BaseEntity;

/**
 * 菜品信息对象 food
 * 
 * @author xx
 * @date 2023-04-08
 */
public class Food extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 菜品ID */
    private Long foodId;

    /** 菜品名称 */
    @Excel(name = "菜品名称")
    private String foodName;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal foodPrice;

    /** 菜品图片 */
    @Excel(name = "菜品图片")
    private String foodPicture;

    /** 菜品备注 */
    @Excel(name = "菜品备注")
    private String foodMsg;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String foodStatus;

    /** 商家名称 */
    private String businessName;

    /** 商家ID */
    private Long businessId;

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
    public void setFoodPrice(BigDecimal foodPrice) 
    {
        this.foodPrice = foodPrice;
    }

    public BigDecimal getFoodPrice() 
    {
        return foodPrice;
    }
    public void setFoodPicture(String foodPicture) 
    {
        this.foodPicture = foodPicture;
    }

    public String getFoodPicture() 
    {
        return foodPicture;
    }
    public void setFoodMsg(String foodMsg) 
    {
        this.foodMsg = foodMsg;
    }

    public String getFoodMsg() 
    {
        return foodMsg;
    }
    public void setFoodStatus(String foodStatus) 
    {
        this.foodStatus = foodStatus;
    }

    public String getFoodStatus() 
    {
        return foodStatus;
    }
    public void setBusinessName(String businessName) 
    {
        this.businessName = businessName;
    }

    public String getBusinessName() 
    {
        return businessName;
    }
    public void setBusinessId(Long businessId) 
    {
        this.businessId = businessId;
    }

    public Long getBusinessId() 
    {
        return businessId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("foodId", getFoodId())
            .append("foodName", getFoodName())
            .append("foodPrice", getFoodPrice())
            .append("foodPicture", getFoodPicture())
            .append("foodMsg", getFoodMsg())
            .append("foodStatus", getFoodStatus())
            .append("businessName", getBusinessName())
            .append("businessId", getBusinessId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
