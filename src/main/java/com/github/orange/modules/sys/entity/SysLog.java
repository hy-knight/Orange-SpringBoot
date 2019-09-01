package com.github.orange.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2019-09-02 11:27:41
 */
@Data
@TableName("sys_log")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统日志")
public class SysLog extends Model<SysLog> implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableId
	@ApiModelProperty(value = "")
	private Long id;
	// 用户名
	@ApiModelProperty(value = "用户名")
	private String username;
	// 用户操作
	@ApiModelProperty(value = "用户操作")
	private String operation;
	// 请求方法
	@ApiModelProperty(value = "请求方法")
	private String method;
	// 请求参数
	@ApiModelProperty(value = "请求参数")
	private String params;
	// 执行时长(毫秒)
	@ApiModelProperty(value = "执行时长(毫秒)")
	private Long time;
	// IP地址
	@ApiModelProperty(value = "IP地址")
	private String ip;
	// 创建时间
	@ApiModelProperty(value = "创建时间")
	private Date createDate;

}
