package com.ruoyi.system.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HxbSpuValueMapper;
import com.ruoyi.system.domain.HxbSpuValue;
import com.ruoyi.system.service.IHxbSpuValueService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品规格Service业务层处理
 * 
 * @author kang
 * @date 2022-05-11
 */
@Service
public class HxbSpuValueServiceImpl extends ServiceImpl<HxbSpuValueMapper, HxbSpuValue> implements IHxbSpuValueService
{
    @Autowired
    private HxbSpuValueMapper hxbSpuValueMapper;

    /**
     * 查询商品规格
     * 
     * @param id 商品规格主键
     * @return 商品规格
     */
    @Override
    public HxbSpuValue selectHxbSpuValueById(Integer id)
    {
        return hxbSpuValueMapper.selectHxbSpuValueById(id);
    }

    /**
     * 查询商品规格列表
     * 
     * @param hxbSpuValue 商品规格
     * @return 商品规格
     */
    @Override
    public List<HxbSpuValue> selectHxbSpuValueList(HxbSpuValue hxbSpuValue)
    {
        return hxbSpuValueMapper.selectHxbSpuValueList(hxbSpuValue);
    }

    /**
     * 新增商品规格
     * 
     * @param hxbSpuValue 商品规格
     * @return 结果
     */
    @Override
    public int insertHxbSpuValue(HxbSpuValue hxbSpuValue)
    {
        return hxbSpuValueMapper.insertHxbSpuValue(hxbSpuValue);
    }

    /**
     * 修改商品规格
     * 
     * @param hxbSpuValue 商品规格
     * @return 结果
     */
    @Override
    public int updateHxbSpuValue(HxbSpuValue hxbSpuValue)
    {
        return hxbSpuValueMapper.updateHxbSpuValue(hxbSpuValue);
    }

    /**
     * 批量删除商品规格
     * 
     * @param ids 需要删除的商品规格主键
     * @return 结果
     */
    @Override
    public int deleteHxbSpuValueByIds(String ids)
    {
        return hxbSpuValueMapper.deleteHxbSpuValueByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品规格信息
     * 
     * @param id 商品规格主键
     * @return 结果
     */
    @Override
    public int deleteHxbSpuValueById(Integer id)
    {
        return hxbSpuValueMapper.deleteHxbSpuValueById(id);
    }

    @Override
    public int updateOrSaveHxbSpuValue(HxbSpuValue hxbSpuValue) {
        if (hxbSpuValue.getId() == null) {
            return hxbSpuValueMapper.insertHxbSpuValue(hxbSpuValue);
        }
        return hxbSpuValueMapper.updateHxbSpuValue(hxbSpuValue);
    }
}
