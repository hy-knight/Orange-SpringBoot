package com.github.orange.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.orange.modules.sys.entity.SysUserRole;
import com.github.orange.modules.sys.mapper.SysUserRoleMapper;
import com.github.orange.modules.sys.service.SysUserRoleService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



/**
 * 用户与角色对应关系
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2019年4月17日
 */
@Service
@AllArgsConstructor
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper,SysUserRole> implements SysUserRoleService {

}
