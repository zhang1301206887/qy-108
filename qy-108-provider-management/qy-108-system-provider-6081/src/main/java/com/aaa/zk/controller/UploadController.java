package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/29 20:09
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.BaseService;
import com.aaa.zk.base.CommonController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.model.Resource;
import com.aaa.zk.service.ResourceService;
import com.aaa.zk.service.UploadService;
import com.aaa.zk.utils.DateUtils;
import com.aaa.zk.utils.FileNameUtils;
import com.aaa.zk.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;


@RestController
public class UploadController extends CommonController<Resource> {
    @Autowired
    private UploadService uploadService;
    @Autowired
    private ResourceService resourceService;

    public BaseService<Resource> getBaseService() {
        return resourceService;
    }

    @PostMapping(value = "/uploadFile",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData uploadFile(@RequestBody MultipartFile file , @RequestParam("memo") String memo
    ,@RequestParam("ref_biz_type") String ref_biz_type , @RequestParam("ref_biz_id") Long ref_biz_id){
        try {
            //获取原始文件的名称(获取目的就是为了获取文件的后缀名)
            String oldFileName = file.getOriginalFilename();
            //获取新的文件名(不带后缀)
            String newFileName = FileNameUtils.getFileName();
            //获取到最终的文件名(新的带后缀的文件名)
            newFileName = newFileName + oldFileName.substring(oldFileName.lastIndexOf("."));
            //获取文件的大小
            long size = file.getSize();
            //获取文件的类型
            String contentType = file.getContentType();
            //获取存入ftp服务器的路径
            String filePath = "/home/ftp/"+DateUtils.formatDate(new Date(), "yyyy/MM/dd");
            //将数据放入Resource中进行附件表信息的添加
            Resource resource = new Resource().setId(IDUtils.getID()).setRefBizId(ref_biz_id).setCreateTime(DateUtils.getCurrentDate())
                    .setMemo(memo).setRefBizType(ref_biz_type).setName(newFileName).setSize(size).setType(contentType).setPath(filePath)
                    .setExtName(oldFileName.substring(oldFileName.lastIndexOf(".")));
            Boolean upload = uploadService.upload(file);
            if (upload){
                Integer add = resourceService.add(resource);
                if (add > 0){
                    return uploadSuccess();
                }
                return uploadFailed();
            }
            return uploadFailed();
        }catch (Exception e){
            e.printStackTrace();
        }
       return uploadFailed();
    }


}
