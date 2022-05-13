package com.ruoyi.web.controller.business;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HxbSpuDetails;
import com.ruoyi.system.service.IHxbSpuDetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品详情Controller
 * 
 * @author kang
 * @date 2022-05-13
 */
@Controller
@RequestMapping("/system/details")
public class HxbSpuDetailsController extends BaseController
{
    private String prefix = "system/details";

    @Autowired
    private IHxbSpuDetailsService hxbSpuDetailsService;

    @RequiresPermissions("system:details:view")
    @GetMapping()
    public String details()
    {
        return prefix + "/details";
    }

    /**
     * 查询商品详情列表
     */
    @RequiresPermissions("system:details:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HxbSpuDetails hxbSpuDetails)
    {
        startPage();
        List<HxbSpuDetails> list = hxbSpuDetailsService.selectHxbSpuDetailsList(hxbSpuDetails);
        return getDataTable(list);
    }

    /**
     * 导出商品详情列表
     */
    @RequiresPermissions("system:details:export")
    @Log(title = "商品详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HxbSpuDetails hxbSpuDetails)
    {
        List<HxbSpuDetails> list = hxbSpuDetailsService.selectHxbSpuDetailsList(hxbSpuDetails);
        ExcelUtil<HxbSpuDetails> util = new ExcelUtil<HxbSpuDetails>(HxbSpuDetails.class);
        return util.exportExcel(list, "商品详情数据");
    }

    /**
     * 新增商品详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品详情
     */
    @RequiresPermissions("system:details:add")
    @Log(title = "商品详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HxbSpuDetails hxbSpuDetails)
    {
        return toAjax(hxbSpuDetailsService.insertHxbSpuDetails(hxbSpuDetails));
    }

    /**
     * 修改商品详情
     */
    @RequiresPermissions("system:details:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        HxbSpuDetails hxbSpuDetails = hxbSpuDetailsService.selectHxbSpuDetailsById(id);
        mmap.put("hxbSpuDetails", hxbSpuDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品详情
     */
    @RequiresPermissions("system:details:edit")
    @Log(title = "商品详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HxbSpuDetails hxbSpuDetails)
    {
        return toAjax(hxbSpuDetailsService.updateHxbSpuDetails(hxbSpuDetails));
    }

    /**
     * 删除商品详情
     */
    @RequiresPermissions("system:details:remove")
    @Log(title = "商品详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hxbSpuDetailsService.deleteHxbSpuDetailsByIds(ids));
    }
}
