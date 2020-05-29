package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/29 20:17
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.service.IQYUploadService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(value = "文件上传", tags = "文件上传的接口")
public class UploadController extends BaseController {
    @Autowired
    IQYUploadService uploadService;
    @PostMapping("/uploadFile")
    public ResultData uploadFile(@RequestBody MultipartFile file){
        System.out.println(file);
        return uploadService.uploadFile(file);
    }
}
