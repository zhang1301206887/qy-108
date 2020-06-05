package com.aaa.zk.service;

import com.aaa.zk.properties.FTPProperties;
import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.utils.FTPUtils;
import com.aaa.zk.utils.FileNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/29 14:53
 * @Description
 **/
@Service
public class UploadService {

    @Autowired
    private FTPProperties ftpProperties;

    /**
     * @author Seven Lee
     * @description
     *      ftp文件上传
     * @param [file]
     * @date 2020/5/29
     * @return java.lang.Boolean
     * @throws
    **/
    public Boolean upload(MultipartFile file) {
        if (null != file){
            // 1.获取原始文件的名称(获取目的就是为了获取文件的后缀名)
            String oldFileName = file.getOriginalFilename();
            // 2.获取新的文件名(不带后缀)
            String newFileName = FileNameUtils.getFileName();
            // 3.获取到最终的文件名(新的带后缀的文件名)
            newFileName = newFileName + oldFileName.substring(oldFileName.lastIndexOf("."));
            try {
                // 4.获取今天日期格式化后的数据(yyyy-MM-dd--->yyyy/MM/dd)
                String filePath = DateUtils.formatDate(new Date(), "yyyy/MM/dd");
                return FTPUtils.uploadFile(ftpProperties.getHost(), ftpProperties.getPort(), ftpProperties.getUsername(),
                        ftpProperties.getPassword(), filePath, ftpProperties.getBasePath(), newFileName, file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
