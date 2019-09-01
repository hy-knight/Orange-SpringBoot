package com.github.orange.common.base;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.orange.common.utils.MPPageConvert;
import com.github.orange.modules.sys.entity.SysUser;

/**
 * Controller公共组件
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2016年11月9日 下午9:42:26
 */

public abstract class AbstractController {
	@Autowired
	protected MPPageConvert mpPageConvert;

	protected SysUser getUser() {
		return (SysUser) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
}
