package com.github.orange.modules.sys.service;

import java.util.Set;

import com.github.orange.modules.sys.entity.SysUser;
import com.github.orange.modules.sys.entity.SysUserToken;

/**
 * shiro相关接口
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2017-06-06 8:49
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    SysUserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUser queryUser(Long userId);
}
