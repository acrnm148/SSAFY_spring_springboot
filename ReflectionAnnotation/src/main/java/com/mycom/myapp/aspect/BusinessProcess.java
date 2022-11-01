package com.mycom.myapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //getBean으로 가져올 것이기  때문
public class BusinessProcess {

	
	public void bp() {
		// Log code가 있어야 할 위치... 그러나 aop를 이용해서 log를 남기려고 함
		System.out.println("BusinessProcess : bp() is called!!");
	}
	
	public void no_bp() {
		System.out.println("BusinessProcess : no_bp() is called!");
	}
	
	public int int_bp() {
		System.out.println("BusinessProcess : int_bp() is called!");
		return 0;
	}
	
	public int int_String_bp(String a, int b, String c) {
		System.out.println("BusinessProcess : int_String_bp() is called!");
		return 0;
	}
	
	
}
