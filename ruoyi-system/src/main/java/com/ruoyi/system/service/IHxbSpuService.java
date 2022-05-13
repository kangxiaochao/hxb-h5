package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HxbSpu;

/**
 * 商品Service接口
 * 
 * @author kang
 * @date 2022-05-11
 */
public interface IHxbSpuService 
{
    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    public HxbSpu selectHxbSpuById(Integer id);

    /**
     * 查询商品列表
     * 
     * @param hxbSpu 商品
     * @return 商品集合
     */
    public List<HxbSpu> selectHxbSpuList(HxbSpu hxbSpu);

    /**
     * 新增商品
     * 
     * @param hxbSpu 商品
     * @return 结果
     */
    public int insertHxbSpu(HxbSpu hxbSpu);

    /**
     * 修改商品
     * 
     * @param hxbSpu 商品
     * @return 结果
     */
    public int updateHxbSpu(HxbSpu hxbSpu);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品主键集合
     * @return 结果
     */
    public int deleteHxbSpuByIds(String ids);

    /**
     * 删除商品信息
     * 
     * @param id 商品主键
     * @return 结果
     */
    public int deleteHxbSpuById(Integer id);
}
