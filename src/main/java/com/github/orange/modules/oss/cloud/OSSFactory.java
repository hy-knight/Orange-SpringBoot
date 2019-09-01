package com.github.orange.modules.oss.cloud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import com.github.orange.common.utils.ConfigConstant;
import com.github.orange.common.utils.Constant;
import com.github.orange.modules.sys.service.SysConfigService;

/**
 * 文件上传Factory
 * @author gmj
 * @email gumingjie.qi@gmail.com
 * @date 2017-03-26 10:18
 */
@Component
@AllArgsConstructor
public class OSSFactory {
    private SysConfigService sysConfigService;

    public CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.MINIO.getValue()){
            return new MinioCloudStorageService(config);
        }
        return null;
    }

}
