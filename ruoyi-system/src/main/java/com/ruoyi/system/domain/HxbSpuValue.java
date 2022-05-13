package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品规格对象 hxb_spu_value
 * 
 * @author kang
 * @date 2022-05-11
 */
@Data
public class HxbSpuValue
{
    private static final long serialVersionUID = 1L;

    /**  */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**  */
    @Excel(name = "")
    private Integer spuId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 销售价格 */
    @Excel(name = "销售价格")
    private BigDecimal salesPrice;

    /** 市场价格 */
    @Excel(name = "市场价格")
    private BigDecimal marketPrice;

}
