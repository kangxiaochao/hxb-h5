package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HxbSpuMapper;
import com.ruoyi.system.domain.HxbSpu;
import com.ruoyi.system.service.IHxbSpuService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品Service业务层处理
 * 
 * @author kang
 * @date 2022-05-11
 */
@Service
public class HxbSpuServiceImpl implements IHxbSpuService 
{
    @Autowired
    private HxbSpuMapper hxbSpuMapper;

    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public HxbSpu selectHxbSpuById(Integer id)
    {
        return hxbSpuMapper.selectHxbSpuById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param hxbSpu 商品
     * @return 商品
     */
    @Override
    public List<HxbSpu> selectHxbSpuList(HxbSpu hxbSpu)
    {
        return hxbSpuMapper.selectHxbSpuList(hxbSpu);
    }

    /**
     * 新增商品
     * 
     * @param hxbSpu 商品
     * @return 结果
     */
    @Override
    public int insertHxbSpu(HxbSpu hxbSpu)
    {
        hxbSpu.setCreateTime(DateUtils.getNowDate());
        return hxbSpuMapper.insertHxbSpu(hxbSpu);
    }

    /**
     * 修改商品
     * 
     * @param hxbSpu 商品
     * @return 结果
     */
    @Override
    public int updateHxbSpu(HxbSpu hxbSpu)
    {
        hxbSpu.setUpdateTime(DateUtils.getNowDate());
        return hxbSpuMapper.updateHxbSpu(hxbSpu);
    }

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteHxbSpuByIds(String ids)
    {
        return hxbSpuMapper.deleteHxbSpuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteHxbSpuById(Integer id)
    {
        return hxbSpuMapper.deleteHxbSpuById(id);
    }
}
