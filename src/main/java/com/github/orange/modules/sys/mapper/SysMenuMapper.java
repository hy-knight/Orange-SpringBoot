package com.github.orange.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.orange.modules.sys.entity.SysMenu;


import java.util.List;

/**
 * 菜单管理
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2016年9月18日 上午9:33:01
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenu> queryNotButtonList();
	
	/**
	 * 查询用户的权限列表
	 */
	List<SysMenu> queryUserList(Long userId);

	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);
}
