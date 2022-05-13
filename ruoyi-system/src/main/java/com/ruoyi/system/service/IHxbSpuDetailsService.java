package com.ruoyi.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.HxbSpuDetails;

/**
 * 商品详情Service接口
 * 
 * @author kang
 * @date 2022-05-13
 */
public interface IHxbSpuDetailsService extends IService<HxbSpuDetails>
{
    /**
     * 查询商品详情
     * 
     * @param id 商品详情主键
     * @return 商品详情
     */
    public HxbSpuDetails selectHxbSpuDetailsById(Integer id);

    /**
     * 查询商品详情列表
     * 
     * @param hxbSpuDetails 商品详情
     * @return 商品详情集合
     */
    public List<HxbSpuDetails> selectHxbSpuDetailsList(HxbSpuDetails hxbSpuDetails);

    /**
     * 新增商品详情
     * 
     * @param hxbSpuDetails 商品详情
     * @return 结果
     */
    public int insertHxbSpuDetails(HxbSpuDetails hxbSpuDetails);

    /**
     * 修改商品详情
     * 
     * @param hxbSpuDetails 商品详情
     * @return 结果
     */
    public int updateHxbSpuDetails(HxbSpuDetails hxbSpuDetails);

    /**
     * 批量删除商品详情
     * 
     * @param ids 需要删除的商品详情主键集合
     * @return 结果
     */
    public int deleteHxbSpuDetailsByIds(String ids);

    /**
     * 删除商品详情信息
     * 
     * @param id 商品详情主键
     * @return 结果
     */
    public int deleteHxbSpuDetailsById(Integer id);
}
