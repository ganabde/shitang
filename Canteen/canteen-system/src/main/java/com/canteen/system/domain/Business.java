package com.canteen.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.canteen.common.annotation.Excel;
import com.canteen.common.core.domain.BaseEntity;

/**
 * 商家信息对象 business
 * 
 * @author xx
 * @date 2023-04-09
 */
public class Business extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商家ID */
    private Long businessId;

    /** 商家名称 */
    @Excel(name = "商家名称")
    private String businessName;

    /** 店铺名称 */
    @Excel(name = "店铺名称")
    private String shopName;

    /** 店铺位置 */
    @Excel(name = "店铺位置")
    private String shopSeat;

    /** 商家手机号 */
    @Excel(name = "商家手机号")
    private String phonenumber;

    /** 店铺图片 */
    @Excel(name = "店铺图片")
    private String shopImage;

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
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setShopSeat(String shopSeat) 
    {
        this.shopSeat = shopSeat;
    }

    public String getShopSeat() 
    {
        return shopSeat;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setShopImage(String shopImage) 
    {
        this.shopImage = shopImage;
    }

    public String getShopImage() 
    {
        return shopImage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("businessId", getBusinessId())
            .append("businessName", getBusinessName())
            .append("shopName", getShopName())
            .append("shopSeat", getShopSeat())
            .append("phonenumber", getPhonenumber())
            .append("shopImage", getShopImage())
            .toString();
    }
}
