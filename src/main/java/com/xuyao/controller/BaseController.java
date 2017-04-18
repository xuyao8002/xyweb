package com.xuyao.controller;

import com.xuyao.service.BaseService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

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
        return baseService.sayHello(i++);
    }
    
    private static ExecutorService es = Executors.newFixedThreadPool(5);
    
    private static AtomicInteger j = new AtomicInteger();
    
    public static void main(String[] args){
    	for(int i = 0; i < 1000 ; i++){
    		es.execute(new Runnable(){

				@Override
				public void run() {
					//j++;
					j.incrementAndGet();
				}
    			
    		});
    	}
    	es.shutdown();
    	while(true){
    		if(es.isTerminated()){
    			System.out.println(j.get());
    			break;
    		}
    	}
    }

}
