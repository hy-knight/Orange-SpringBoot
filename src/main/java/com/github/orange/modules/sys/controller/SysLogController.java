package com.github.orange.modules.sys.controller;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.orange.common.base.AbstractController;
import com.github.orange.common.utils.R;
import com.github.orange.modules.sys.entity.SysLog;
import com.github.orange.modules.sys.service.SysLogService;

import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * 系统日志
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2017-03-08 10:40:56
 */
@Controller
@AllArgsConstructor
@RequestMapping("/sys/log")
public class SysLogController extends AbstractController {
	private final SysLogService sysLogService;


	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("sys:log:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		QueryWrapper<SysLog> queryWrapper = new QueryWrapper<>();
		if(MapUtil.getStr(params,"key") != null){
			queryWrapper
					.like("username",MapUtil.getStr(params,"key"))
					.or()
					.like("operation",MapUtil.getStr(params,"key"));
		}
		IPage<SysLog> sysLogList = sysLogService.page(mpPageConvert.<SysLog>pageParamConvert(params),queryWrapper);
		return R.ok().put("page", mpPageConvert.pageValueConvert(sysLogList));
	}
	
}
