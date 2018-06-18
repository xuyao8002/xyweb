package com.xuyao.controller;

import com.xuyao.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuyao on 2017/4/11.
 */
@Controller
@RequestMapping("ehcache")
public class EhCacheController {

    @Autowired
    private BaseService baseService;

    private int i = 0;

    @RequestMapping("get/{key}")
    @ResponseBody
    public String get(@PathVariable("key") String key){
		/*LogHandle handle = new LogHandle(baseService);
		BaseService bs = (BaseService) Proxy.newProxyInstance(baseService.getClass().getClassLoader(), baseService.getClass().getInterfaces(), handle);
		bs.printInfo();
		bs.sayHello();
        return bs.sayHello(i++);*/
        //baseService.get(key);
		return baseService.get(key);//baseService.sayHello(i++);
    }
    
    @RequestMapping("put/{key}/{value}/{i}/{i1}")
    @ResponseBody
    public String show1(@PathVariable("key") String key, @PathVariable("value") String value, @PathVariable("i") int i, @PathVariable("i1") int i1){
        //baseService.printInfo();
        baseService.put(key, value, i, i1);
        return key + ", " + value;//"i'am going to riding";
    }

}
