package com.xuyao.controller;

import com.xuyao.utils.HttpUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

@Controller
@RequestMapping("/upDownload")
public class UpDownloadController {

    @RequestMapping("down/{name}")
    public ResponseEntity<byte[]> down(@PathVariable("name") String name) throws UnsupportedEncodingException {

        String fileUrl = "xxxx";
        byte[] bytes = HttpUtils.getBytes(fileUrl);
        String fileName = "图片.png";
        fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);

    }

}
