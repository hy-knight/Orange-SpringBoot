package com.github.orange.modules.gen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.orange.common.utils.GenUtils;
import com.github.orange.modules.gen.entity.ColumnEntity;
import com.github.orange.modules.gen.entity.GenConfig;
import com.github.orange.modules.gen.entity.InfoRmationSchema;
import com.github.orange.modules.gen.mapper.SysGenMapper;
import com.github.orange.modules.gen.service.SysGenService;

import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.zip.ZipOutputStream;

@Service
@AllArgsConstructor
public class SysGenServiceImpl extends ServiceImpl<SysGenMapper,InfoRmationSchema> implements SysGenService {

    private final SysGenMapper sysGenMapper;
    private final GenUtils genUtils;

    @Override
    public IPage<InfoRmationSchema> queryTableList(@SuppressWarnings("rawtypes") IPage page, QueryWrapper<InfoRmationSchema> entityWrapper) {
        return sysGenMapper.queryTableList(page,entityWrapper);
    }

    public byte[] generatorCode(GenConfig config) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for(String tableName : config.getGenTable()){
            //查询表信息
            InfoRmationSchema table = sysGenMapper.queryTableList(new QueryWrapper<InfoRmationSchema>().eq("tableName",tableName));
            //查询列信息
            List<ColumnEntity> columns = sysGenMapper.queryColumns(new QueryWrapper<ColumnEntity>().eq("tableName",tableName));
            //生成代码
            genUtils.generatorCode(config,table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
