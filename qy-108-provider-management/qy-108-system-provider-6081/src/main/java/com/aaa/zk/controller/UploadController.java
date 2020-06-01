package com.aaa.zk.controller;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/29 20:09
 *@Description:
 */

import com.aaa.zk.base.BaseController;
import com.aaa.zk.base.ResultData;
import com.aaa.zk.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class UploadController extends BaseController {
    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/uploadFile",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData uploadFile(@RequestBody MultipartFile file){
        Boolean upload = uploadService.upload(file);
        if (upload){
            return uploadSuccess();
        }
        return uploadFailed();
    }
}
