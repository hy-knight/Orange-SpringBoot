package com.github.orange.modules.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.orange.common.annotation.AuthIgnore;
import com.github.orange.common.annotation.LoginUser;
import com.github.orange.common.base.AbstractController;
import com.github.orange.modules.sys.entity.SysUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "标签",value = "测试接口名")
@RestController
@RequestMapping("/app")
public class TestController2 extends AbstractController {

    /**
     * @Author gmj
     * @Description //TODO 需要token
     * @Date 14:42 2019/4/19
     * @Param [userId]
     * @return java.lang.String
     **/
	@ApiOperation(value = "获得用户id")
    @RequestMapping(value = "/getUserId",method = RequestMethod.POST)
    public String getUserId(@LoginUser @ApiParam("用户登录的Id")String userId,SysUser sysUser){
        return "userId:" + userId;
    }

    /**
     * @Author gmj
     * @Description //TODO 不需要token
     * @Date 14:43 2019/4/19
     * @Param []
     * @return java.lang.String
     **/
    @AuthIgnore
    @RequestMapping(value = "/hello")
    public String hello(){
        return "--------------------hello";
    }

}
