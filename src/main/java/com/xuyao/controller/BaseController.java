package com.xuyao.controller;

import com.xuyao.annotation.ControllerLog;
import com.xuyao.annotation.RateLimit;
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
    @ControllerLog(desc = "show me")
    public String show(){
		/*LogHandle handle = new LogHandle(baseService);
		BaseService bs = (BaseService) Proxy.newProxyInstance(baseService.getClass().getClassLoader(), baseService.getClass().getInterfaces(), handle);
		bs.printInfo();
		bs.sayHello();
        return bs.sayHello(i++);*/
		return baseService.sayHello(i++);
    }
    
    @RequestMapping("show1")
    @ResponseBody
    @RateLimit(permitsPerSecond = 5)
//    @ControllerLog(desc = "show me the code")
    public String show1(){
        //baseService.printInfo();
        return "i'am going to riding";
    }

    @RequestMapping("show2")
    @ResponseBody
    @RateLimit(permitsPerSecond = 4, key = "show2")
//    @ControllerLog(desc = "show me the code")
    public String show2(){
        //baseService.printInfo();
        return "i'am going to shopping";
    }

}
