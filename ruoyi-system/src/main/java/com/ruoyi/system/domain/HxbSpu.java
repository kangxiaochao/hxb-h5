package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 商品对象 hxb_spu
 * 
 * @author kang
 * @date 2022-05-11
 */
@Data
public class HxbSpu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 小标题 */
    @Excel(name = "小标题")
    private String titleMinor;

    /** logo */
    @Excel(name = "logo")
    private String logo;

    /** 图片 */
    @Excel(name = "图片")
    private String banner;

    private String isShow;
    private String isDel;
    private String detailsType;
    private String hxbSpuValue;
    private String hxbSpuDetails;
    private List<HxbSpuValue> hxbSpuValueList;
    private List<HxbSpuDetails> HxbSpuDetailsList;
}
