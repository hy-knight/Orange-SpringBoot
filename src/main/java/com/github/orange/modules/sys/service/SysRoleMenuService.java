package com.github.orange.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.orange.modules.sys.entity.SysRoleMenu;

import java.util.List;



/**
 * 角色与菜单对应关系
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2016年9月18日 上午9:42:30
 */
public interface SysRoleMenuService  extends IService<SysRoleMenu> {
	
	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);
	
}
