package com.xuyao.aspect;

import org.aspectj.lang.JoinPoint;

public class LogTest {
	public void before(JoinPoint joinpoint) {
		joinpoint.getArgs();// 此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
		System.out.println("被拦截方法调用之前调用此方法，输出此语句");
	}

	public void after(JoinPoint joinpoint) {
		System.out.println("被拦截方法调用之后调用此方法，输出此语句");
	}
}
