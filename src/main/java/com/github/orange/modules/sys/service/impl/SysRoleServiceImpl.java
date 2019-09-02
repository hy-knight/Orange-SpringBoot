package com.github.orange.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.orange.common.exception.RRException;
import com.github.orange.common.utils.Constant;
import com.github.orange.modules.sys.entity.SysRole;
import com.github.orange.modules.sys.mapper.SysRoleMapper;
import com.github.orange.modules.sys.service.SysRoleMenuService;
import com.github.orange.modules.sys.service.SysRoleService;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;



/**
 * 角色
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2019年4月17日
 */

@Lazy
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole> implements SysRoleService {

	private final SysRoleMapper sysRoleMapper;
	private final SysRoleMenuService sysRoleMenuService;

	@Override
	@Transactional
	public void saveRoleMenu(SysRole role) {
		role.setCreateTime(new Date());
		sysRoleMapper.insert(role);
		
		//检查权限是否越权
		checkPrems(role);
		
		//保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void updateRoleMenu(SysRole role) {
		sysRoleMapper.updateById(role);
		
		//检查权限是否越权
		checkPrems(role);
		
		//更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	public List<Long> queryRoleIdList(Long createUserId) {
		return sysRoleMapper.queryRoleIdList(createUserId);
	}

	/**
	 * @Author gmj
	 * @Description //TODO deleteById  报 Parameter 'roleId' not found. Available parameters are [array]
	 * @Date 15:58 2019/4/18
	 * @Param [ids]
	 * @return void
	 **/
	@Override
	public void deleteBath(Long[] ids) {
		baseMapper.deleteBatchIds(Arrays.asList(ids));
		//Arrays.stream(ids).forEach(id->baseMapper.deleteById(id));
	}

	/**
	 * 检查权限是否越权
	 */
	private void checkPrems(SysRole role){
		//如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
		if(role.getCreateUserId() == Constant.SUPER_ADMIN){
			return ;
		}
		
		//查询用户所拥有的菜单列表
		List<Long> menuIdList = sysRoleMapper.queryAllMenuId(role.getCreateUserId());
		
		//判断是否越权
		if(!menuIdList.containsAll(role.getMenuIdList())){
			throw new RRException("新增角色的权限，已超出你的权限范围");
		}
	}
}
