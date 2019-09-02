package com.github.orange.modules.apkversion.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.orange.common.annotation.SysLog;
import com.github.orange.common.base.AbstractController;
import com.github.orange.common.utils.R;
import com.github.orange.modules.apkversion.entity.ApkVersion;
import com.github.orange.modules.apkversion.service.ApkVersionService;

import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;



/**
 * APK版本管理
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2019-04-28 15:56:33
 */
@RestController
@AllArgsConstructor
@RequestMapping("/apkversion/apkversion")
public class ApkVersionController  extends AbstractController {
    private final  ApkVersionService apkVersionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("apkversion:apkversion:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        QueryWrapper<ApkVersion> queryWrapper = new QueryWrapper<>();
        IPage<ApkVersion> sysConfigList = apkVersionService.page(mpPageConvert.<ApkVersion>pageParamConvert(params),queryWrapper);
        return R.ok().put("page", mpPageConvert.pageValueConvert(sysConfigList));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("apkversion:apkversion:info")
    public R info(@PathVariable("id") Long id){
        return R.ok().put("apkVersion", apkVersionService.getById(id));
    }


    /**
     * 新增APK版本管理
     */
    @SysLog("新增APK版本管理数据")
    @RequestMapping("/save")
    @RequiresPermissions("apkversion:apkversion:save")
    public R save(@RequestBody ApkVersion apkVersion){
        apkVersion.setUserId(getUserId());
        apkVersionService.save(apkVersion);
        return R.ok();
    }


    /**
     * 修改
     */
    @SysLog("修改APK版本管理数据")
    @RequestMapping("/update")
    @RequiresPermissions("apkversion:apkversion:update")
    public R update(@RequestBody ApkVersion apkVersion){
        apkVersion.setUpdateTime(new Date());
		apkVersionService.updateById(apkVersion);
        return R.ok();
    }


    /**
     * 删除
     */
    @SysLog("删除APK版本管理数据")
    @RequestMapping("/delete")
    @RequiresPermissions("apkversion:apkversion:delete")
    public R delete(@RequestBody Long[] ids){
		apkVersionService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
	
}
