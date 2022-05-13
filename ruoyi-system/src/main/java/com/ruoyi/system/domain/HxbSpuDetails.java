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
 * 商品详情对象 hxb_spu_details
 * 
 * @author kang
 * @date 2022-05-13
 */
@Data
public class HxbSpuDetails {
    private static final long serialVersionUID = 1L;

    /**  */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /** 名称 */
    @Excel(name = "名称")
    private String detailsName;

    /** 内容 */
    @Excel(name = "内容")
    private String detailsContent;

    /** 海报 */
    @Excel(name = "海报")
    private String detailsPosters;

    private Integer spuId;


}
