package com.github.orange.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.orange.modules.sys.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2016年9月18日 上午9:34:11
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 修改密码
	 */
	int updatePassword(Map<String, Object> map);

	void saveUserRole(Map<String, Object> map);
}
