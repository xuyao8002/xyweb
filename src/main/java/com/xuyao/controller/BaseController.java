package com.xuyao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuyao on 2017/4/11.
 */
@Controller
@RequestMapping("base")
public class BaseController {

    @RequestMapping("show")
    @ResponseBody
    public String show(){
        return "I'am ye";
    }
}
