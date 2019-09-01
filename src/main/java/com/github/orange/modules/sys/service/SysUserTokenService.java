package com.github.orange.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.orange.common.utils.R;
import com.github.orange.modules.sys.entity.SysUserToken;

/**
 * 用户Token
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService extends IService<SysUserToken> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
