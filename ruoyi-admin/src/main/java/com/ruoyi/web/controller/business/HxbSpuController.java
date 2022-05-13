package com.ruoyi.web.controller.business;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.system.domain.HxbSpuDetails;
import com.ruoyi.system.domain.HxbSpuValue;
import com.ruoyi.system.service.IHxbSpuDetailsService;
import com.ruoyi.system.service.IHxbSpuValueService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HxbSpu;
import com.ruoyi.system.service.IHxbSpuService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author kang
 * @date 2022-05-11
 */
@Controller
@RequestMapping("/system/spu")
public class HxbSpuController extends BaseController
{
    private String prefix = "system/spu";

    @Autowired
    private IHxbSpuService hxbSpuService;
    @Autowired
    private IHxbSpuValueService hxbSpuValueService;
    @Autowired
    private IHxbSpuDetailsService hxbSpuDetailsService;

    @RequiresPermissions("system:spu:view")
    @GetMapping()
    public String spu()
    {
        return prefix + "/spu";
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("system:spu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HxbSpu hxbSpu)
    {
        startPage();
        List<HxbSpu> list = hxbSpuService.selectHxbSpuList(hxbSpu);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("system:spu:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HxbSpu hxbSpu)
    {
        List<HxbSpu> list = hxbSpuService.selectHxbSpuList(hxbSpu);
        ExcelUtil<HxbSpu> util = new ExcelUtil<HxbSpu>(HxbSpu.class);
        return util.exportExcel(list, "商品数据");
    }

    /**
     * 新增商品
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @RequiresPermissions("system:spu:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HxbSpu hxbSpu)
    {
        String hxbSpuValue = hxbSpu.getHxbSpuValue();
        List<HxbSpuValue> hxbSpuValues = JSONObject.parseArray(hxbSpuValue, HxbSpuValue.class);
        int i = hxbSpuService.insertHxbSpu(hxbSpu);
        for (HxbSpuValue spuValue : hxbSpuValues) {
            HxbSpuValue hxbSpuValue1 = new HxbSpuValue();
            hxbSpuValue1.setSpuId(hxbSpu.getId());
            hxbSpuValue1.setName(spuValue.getName());
            hxbSpuValue1.setMarketPrice(spuValue.getMarketPrice());
            hxbSpuValue1.setSalesPrice(spuValue.getSalesPrice());
            hxbSpuValueService.insertHxbSpuValue(hxbSpuValue1);
        }
        String hxbSpuDetails = hxbSpu.getHxbSpuDetails();
        List<HxbSpuDetails> hxbSpuDetails1 = JSONObject.parseArray(hxbSpuDetails, HxbSpuDetails.class);
        for (HxbSpuDetails spuDetails : hxbSpuDetails1) {
            HxbSpuDetails details = new HxbSpuDetails();
            details.setSpuId(hxbSpu.getId());
            details.setDetailsName(spuDetails.getDetailsName());
            details.setDetailsContent(spuDetails.getDetailsContent());
            details.setDetailsPosters(spuDetails.getDetailsPosters());
            hxbSpuDetailsService.insertHxbSpuDetails(details);
        }
        return toAjax(i);
    }

    /**
     * 修改商品
     */
    @RequiresPermissions("system:spu:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        HxbSpu hxbSpu = hxbSpuService.selectHxbSpuById(id);
        hxbSpu.setHxbSpuDetailsList(hxbSpuDetailsService.list(Wrappers.<HxbSpuDetails>lambdaQuery().eq(HxbSpuDetails::getSpuId, hxbSpu.getId())));
        List<HxbSpuValue> list = hxbSpuValueService.list(Wrappers.<HxbSpuValue>lambdaQuery().eq(HxbSpuValue::getSpuId, hxbSpu.getId()));
        hxbSpu.setHxbSpuValueList(list);
        mmap.put("hxbSpu", hxbSpu);

        return prefix + "/edit";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("system:spu:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HxbSpu hxbSpu)
    {
        String hxbSpuValue = hxbSpu.getHxbSpuValue();
        List<HxbSpuValue> hxbSpuValues = JSONObject.parseArray(hxbSpuValue, HxbSpuValue.class);
        for (HxbSpuValue spuValue : hxbSpuValues) {
            HxbSpuValue hxbSpuValue1 = new HxbSpuValue();
            hxbSpuValue1.setId(spuValue.getId());
            hxbSpuValue1.setSpuId(hxbSpu.getId());
            hxbSpuValue1.setName(spuValue.getName());
            hxbSpuValue1.setMarketPrice(spuValue.getMarketPrice());
            hxbSpuValue1.setSalesPrice(spuValue.getSalesPrice());
            hxbSpuValueService.updateOrSaveHxbSpuValue(hxbSpuValue1);
        }
        String hxbSpuDetails = hxbSpu.getHxbSpuDetails();
        List<HxbSpuDetails> hxbSpuDetails1 = JSONObject.parseArray(hxbSpuDetails, HxbSpuDetails.class);
        boolean remove = hxbSpuDetailsService.remove(Wrappers.<HxbSpuDetails>lambdaQuery().eq(HxbSpuDetails::getSpuId, hxbSpu.getId()));
        for (HxbSpuDetails spuDetails : hxbSpuDetails1) {
            HxbSpuDetails details = new HxbSpuDetails();
            details.setSpuId(hxbSpu.getId());
            details.setDetailsName(spuDetails.getDetailsName());
            details.setDetailsContent(spuDetails.getDetailsContent());
            details.setDetailsPosters(spuDetails.getDetailsPosters());
            hxbSpuDetailsService.save(details);
        }
        return toAjax(hxbSpuService.updateHxbSpu(hxbSpu));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("system:spu:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hxbSpuService.deleteHxbSpuByIds(ids));
    }
}
