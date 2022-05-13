package com.ruoyi.web.controller.business;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HxbSpuValue;
import com.ruoyi.system.service.IHxbSpuValueService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品规格Controller
 * 
 * @author kang
 * @date 2022-05-11
 */
@Controller
@RequestMapping("/system/value")
public class HxbSpuValueController extends BaseController
{
    private String prefix = "system/value";

    @Autowired
    private IHxbSpuValueService hxbSpuValueService;

    @RequiresPermissions("system:value:view")
    @GetMapping()
    public String value()
    {
        return prefix + "/value";
    }

    /**
     * 查询商品规格列表
     */
    @RequiresPermissions("system:value:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HxbSpuValue hxbSpuValue)
    {
        startPage();
        List<HxbSpuValue> list = hxbSpuValueService.selectHxbSpuValueList(hxbSpuValue);
        return getDataTable(list);
    }

    /**
     * 导出商品规格列表
     */
    @RequiresPermissions("system:value:export")
    @Log(title = "商品规格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HxbSpuValue hxbSpuValue)
    {
        List<HxbSpuValue> list = hxbSpuValueService.selectHxbSpuValueList(hxbSpuValue);
        ExcelUtil<HxbSpuValue> util = new ExcelUtil<HxbSpuValue>(HxbSpuValue.class);
        return util.exportExcel(list, "商品规格数据");
    }

    /**
     * 新增商品规格
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品规格
     */
//    @RequiresPermissions("system:value:add")
//    @Log(title = "商品规格", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody List<HxbSpuValue> hxbSpuValue)
    {
        System.out.println(hxbSpuValue);

        return null;
//        return toAjax(hxbSpuValueService.insertHxbSpuValue(hxbSpuValue));
    }

    /**
     * 修改商品规格
     */
    @RequiresPermissions("system:value:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        HxbSpuValue hxbSpuValue = hxbSpuValueService.selectHxbSpuValueById(id);
        mmap.put("hxbSpuValue", hxbSpuValue);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品规格
     */
    @RequiresPermissions("system:value:edit")
    @Log(title = "商品规格", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HxbSpuValue hxbSpuValue)
    {
        return toAjax(hxbSpuValueService.updateHxbSpuValue(hxbSpuValue));
    }

    /**
     * 删除商品规格
     */
    @RequiresPermissions("system:value:remove")
    @Log(title = "商品规格", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hxbSpuValueService.deleteHxbSpuValueByIds(ids));
    }
}
