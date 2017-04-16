package com.xuyao.controller;

import com.xuyao.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuyao on 2017/4/11.
 */
@Controller
@RequestMapping("base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    private int i = 0;

    @RequestMapping("show")
    @ResponseBody
    public String show(){
        baseService.printInfo();
        return i++ + ", " + baseService.sayHello();
    }

}
