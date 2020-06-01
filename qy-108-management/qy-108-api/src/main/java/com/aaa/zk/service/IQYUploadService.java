package com.aaa.zk.service;/*
 *@Company：
 *@Author：何康
 *@Date：2020/5/29 20:16
 *@Description:
 */

import com.aaa.zk.base.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "upload-interface")
public interface IQYUploadService {
    @PostMapping(value = "/uploadFile",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResultData uploadFile(@RequestBody MultipartFile file);
}
