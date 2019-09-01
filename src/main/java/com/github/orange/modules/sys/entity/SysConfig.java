package com.github.orange.modules.sys.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * 系统配置信息
 * 
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2016年12月4日 下午6:43:36
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SysConfig extends Model<SysConfig> {

	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	@NotBlank(message="参数名不能为空")
	private String configKey;

	@NotBlank(message="参数值不能为空")
	private String configValue;

	private Integer configStatus;

	private String remark;

}
