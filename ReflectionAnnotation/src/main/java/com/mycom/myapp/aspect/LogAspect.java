package com.mycom.myapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Spring에서 내부적으로 관리되어야 하는 컴포넌트
@Component
// aop 를 처리하는 특별한 컴포넌트
@Aspect
public class LogAspect {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// BusinessProcess의 method에 끼어들려고 한다. (Aspect)
	
	// Pointcut으로 끼어들 method를 선택
	// Pointcut은 메소드 singniture를 이용
	
	@Pointcut(value="execution( int com.mycom.myapp.aspect.*.*(..))") //모든 클래스.모든메소드(모든파라미터) //return type - package - class - method( parameter)
	private void logPointCut() {} //pointcut의 이름이 됨 //어느 클래스의 어느 메소드에 끼어드는지 표현
	
	
	// 이런 로그를 남기고 싶다 - 다른 메소드들 logPointcut 호출될 때마다 끼어들어서 호출됨
	//Advise를 이용해서 앞, 뒤 등 메소드 호출별 시점을 지정
//	@Before("logPointCut()")
//	public void beforeLog(JoinPoint joinPoint) { //joinpoint: 끼어드는 메소드의 연결 정보
//		Signature signature = joinPoint.getSignature();
//		System.out.println("[sysout : Before] 메소드이름 : "+ signature.getName()); //단순 출력(항상 출력)
//		logger.debug("Logger : Before] 메소드 이름 : "+ signature.getName()); // 메세지를 logger를 통해서 debug level로 출력
//	}
//	
//	/*
//	 * 누구를 대상으로 할지 : pointcut이 잡아줌
//	 * 호출 시점 : advise가 잡아줌
//	 * 
//	 * */
//
//	@After("logPointCut()")
//	public void afterLog(JoinPoint joinPoint) { //joinpoint: 끼어드는 메소드의 연결 정보
//		Signature signature = joinPoint.getSignature();
//		System.out.println("[sysout : Before] 메소드이름 : "+ signature.getName()); //단순 출력(항상 출력)
//		logger.debug("Logger : Before] 메소드 이름 : "+ signature.getName()); // 메세지를 logger를 통해서 debug level로 출력
//	}
	@Pointcut(value="execution( int com.mycom.myapp.aspect.*.*(..))") //모든 클래스.모든메소드(모든파라미터) //return type - package - class - method( parameter)
	private void logPointCut2() {} //pointcut의 이름이 됨 //어느 클래스의 어느 메소드에 끼어드는지 표현
	
	
	// 이런 로그를 남기고 싶다 - 다른 메소드들 logPointcut 호출될 때마다 끼어들어서 호출됨
	//Advise를 이용해서 앞, 뒤 등 메소드 호출별 시점을 지정
	@Before("logPointCut2()")
	public void beforeLog2(JoinPoint joinPoint) { //joinpoint: 끼어드는 메소드의 연결 정보
		Signature signature = joinPoint.getSignature();
		System.out.println("[sysout : Before] 메소드이름 : "+ signature.getName()); //단순 출력(항상 출력)
		logger.debug("Logger : Before] 메소드 이름 : "+ signature.getName()); // 메세지를 logger를 통해서 debug level로 출력
	}
}
