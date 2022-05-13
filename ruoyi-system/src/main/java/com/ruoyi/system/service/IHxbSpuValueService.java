package com.ruoyi.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.HxbSpuValue;

/**
 * 商品规格Service接口
 * 
 * @author kang
 * @date 2022-05-11
 */
public interface IHxbSpuValueService  extends IService<HxbSpuValue>
{
    /**
     * 查询商品规格
     * 
     * @param id 商品规格主键
     * @return 商品规格
     */
    public HxbSpuValue selectHxbSpuValueById(Integer id);

    /**
     * 查询商品规格列表
     * 
     * @param hxbSpuValue 商品规格
     * @return 商品规格集合
     */
    public List<HxbSpuValue> selectHxbSpuValueList(HxbSpuValue hxbSpuValue);

    /**
     * 新增商品规格
     * 
     * @param hxbSpuValue 商品规格
     * @return 结果
     */
    public int insertHxbSpuValue(HxbSpuValue hxbSpuValue);

    /**
     * 修改商品规格
     * 
     * @param hxbSpuValue 商品规格
     * @return 结果
     */
    public int updateHxbSpuValue(HxbSpuValue hxbSpuValue);

    /**
     * 批量删除商品规格
     * 
     * @param ids 需要删除的商品规格主键集合
     * @return 结果
     */
    public int deleteHxbSpuValueByIds(String ids);

    /**
     * 删除商品规格信息
     * 
     * @param id 商品规格主键
     * @return 结果
     */
    public int deleteHxbSpuValueById(Integer id);

    public int updateOrSaveHxbSpuValue(HxbSpuValue hxbSpuValue);
}
