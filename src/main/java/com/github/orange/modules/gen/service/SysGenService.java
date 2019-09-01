package com.github.orange.modules.gen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.orange.modules.gen.entity.GenConfig;
import com.github.orange.modules.gen.entity.InfoRmationSchema;

public interface SysGenService extends IService<InfoRmationSchema> {

    IPage<InfoRmationSchema> queryTableList(@SuppressWarnings("rawtypes") IPage page, QueryWrapper<InfoRmationSchema> entityWrapper);

    byte[] generatorCode(GenConfig config);
}
