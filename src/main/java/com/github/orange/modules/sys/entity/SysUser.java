package com.github.orange.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2016年9月18日 上午9:28:55
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户实体类",description = "用户对象")
public class SysUser extends Model<SysUser> {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID",example = "123")
	@TableId(value = "user_id", type = IdType.AUTO)
	private Long userId;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	@NotBlank(message="用户名不能为空")
	private String username;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	@NotBlank(message="密码不能为空")
	private String password;

	/**
	 * 盐
	 */
	@ApiModelProperty(value = "盐")
	private String salt;

	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
	@NotBlank(message="邮箱不能为空")
	private String email;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	private String mobile;

	/**
	 * 状态  0：禁用   1：正常
	 */
	@ApiModelProperty(value = "状态")
	private Integer status;

	
	/**
	 * 创建者ID
	 */
	@ApiModelProperty(value = "创建者ID")
	private Long createUserId;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	
	@TableField(exist = false)
	private List<Long> roleIdList;
}
