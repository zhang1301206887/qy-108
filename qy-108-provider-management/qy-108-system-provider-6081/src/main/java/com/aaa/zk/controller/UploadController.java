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
            String name = file.getOriginalFilename();
            long size = file.getSize();
            String contentType = file.getContentType();
            String filePath = DateUtils.formatDate(new Date(), "yyyy/MM/dd");
            String[] s = name.split("\\.");
            Resource resource = new Resource().setId(IDUtils.getID()).setRefBizId(ref_biz_id).setCreateTime(DateUtils.getCurrentDate())
                    .setMemo(memo).setRefBizType(ref_biz_type).setName(name).setSize(size).setType(contentType).setPath("/home/ftp/"+filePath)
                    .setExtName("."+s[1]);
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
