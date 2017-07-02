package com.xuyao.aspect;

import com.xuyao.annotation.ControllerLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

public class LogTest {
	public void before(JoinPoint joinPoint) {
		System.out.println("方法执行前");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String ip = request.getRemoteAddr();
		System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
		System.out.println("请求IP:" + ip);
		System.out.println("desc:" + getControllerLogDesc(joinPoint));
		//joinpoint.getArgs();// 此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象

	}

	public  static String getControllerLogDesc(JoinPoint joinPoint){
		String desc = null;
		//目标类
		Object target = joinPoint.getTarget();
		//目标类Class字节码
		Class<?> targetClass = target.getClass();
		//目标方法的签名
		Signature signature = joinPoint.getSignature();
		//目标方法名
		String methodName = signature.getName();
		//目标方法的参数类型数组
		Class<?>[] parameterTypes = ((MethodSignature)signature).getMethod().getParameterTypes();
		ControllerLog log = null;
		Method method = null;
		try {
			method = targetClass.getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		if (method != null && method.isAnnotationPresent(ControllerLog.class)){
			log = method.getAnnotation(ControllerLog.class);
		}
		if(log != null){
			desc = log.desc();
		}
		return desc;
	}

	public void after(JoinPoint joinPoint) {
		System.out.println("方法执行后");
		/*HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String ip = request.getRemoteAddr();
		System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
		System.out.println("请求IP:" + ip);*/
	}
}
