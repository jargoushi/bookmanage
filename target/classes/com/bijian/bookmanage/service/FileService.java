package com.bijian.bookmanage.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/23
 * @Content:
 */
@Service
public class FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class);
    private static final String END_POINT = "http://oss-cn-shanghai.aliyuncs.com";

    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${oss.bucketName}")
    private String bucketName;

    /**
     * 图片上传返回链接
     * @param file 本地图片
     * @return
     */
    public String upload(MultipartFile file) {

        URL url = null;
        OSSClient client = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            // 获取文件后缀名
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 生成上传文件名
            String finalFileName = System.currentTimeMillis() + "" + new SecureRandom().nextInt(0x0400) + suffixName;
            String objectName = sdf.format(new Date()) + "/" + finalFileName;
            client = new OSSClient(END_POINT, accessKeyId, accessKeySecret);
            client.putObject(bucketName, objectName, file.getInputStream());
            // 设置URL过期时间为1小时。
            Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
            // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
            url = client.generatePresignedUrl(bucketName, objectName, expiration);
        } catch (Exception e) {
            logger.error("文件资源上传失败", e);
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }
        return url == null ? "" : url.toString();
    }
}
