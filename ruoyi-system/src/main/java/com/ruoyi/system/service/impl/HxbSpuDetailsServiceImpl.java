package com.ruoyi.system.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HxbSpuDetailsMapper;
import com.ruoyi.system.domain.HxbSpuDetails;
import com.ruoyi.system.service.IHxbSpuDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品详情Service业务层处理
 * 
 * @author kang
 * @date 2022-05-13
 */
@Service
public class HxbSpuDetailsServiceImpl extends ServiceImpl<HxbSpuDetailsMapper,HxbSpuDetails> implements IHxbSpuDetailsService
{
    @Autowired
    private HxbSpuDetailsMapper hxbSpuDetailsMapper;

    /**
     * 查询商品详情
     * 
     * @param id 商品详情主键
     * @return 商品详情
     */
    @Override
    public HxbSpuDetails selectHxbSpuDetailsById(Integer id)
    {
        return hxbSpuDetailsMapper.selectHxbSpuDetailsById(id);
    }

    /**
     * 查询商品详情列表
     * 
     * @param hxbSpuDetails 商品详情
     * @return 商品详情
     */
    @Override
    public List<HxbSpuDetails> selectHxbSpuDetailsList(HxbSpuDetails hxbSpuDetails)
    {
        return hxbSpuDetailsMapper.selectHxbSpuDetailsList(hxbSpuDetails);
    }

    /**
     * 新增商品详情
     * 
     * @param hxbSpuDetails 商品详情
     * @return 结果
     */
    @Override
    public int insertHxbSpuDetails(HxbSpuDetails hxbSpuDetails)
    {
        return hxbSpuDetailsMapper.insertHxbSpuDetails(hxbSpuDetails);
    }

    /**
     * 修改商品详情
     * 
     * @param hxbSpuDetails 商品详情
     * @return 结果
     */
    @Override
    public int updateHxbSpuDetails(HxbSpuDetails hxbSpuDetails)
    {
        return hxbSpuDetailsMapper.updateHxbSpuDetails(hxbSpuDetails);
    }

    /**
     * 批量删除商品详情
     * 
     * @param ids 需要删除的商品详情主键
     * @return 结果
     */
    @Override
    public int deleteHxbSpuDetailsByIds(String ids)
    {
        return hxbSpuDetailsMapper.deleteHxbSpuDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品详情信息
     * 
     * @param id 商品详情主键
     * @return 结果
     */
    @Override
    public int deleteHxbSpuDetailsById(Integer id)
    {
        return hxbSpuDetailsMapper.deleteHxbSpuDetailsById(id);
    }
}
