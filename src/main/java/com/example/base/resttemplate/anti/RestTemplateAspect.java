package com.example.base.resttemplate.anti;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.base.resttemplate.anti.response.ResponseAbstract;

import lombok.extern.slf4j.Slf4j;
/**
 * 1箇所のみを何でも一致させたい場合は「*」を、個数に関係なく全てを一致させたい場合は「..」を利用する。
上記をの場合、引数部分が「..」となっているが、
これは引数の個数に関係なく
「どんな型で引数が何個指定されていてもOK」なメソッドが対象となる
(ほぼ全てのメソッドが対象となる)。
 * @author yoshinari
 *
 */
@Slf4j
@Component
@Aspect
public class RestTemplateAspect {
	private static final ResponseErrorHandler errorHandler;
	static {
		errorHandler = new ResponseErrorHandler();
	}
	@AfterReturning(pointcut="execution(* com.example.base.resttemplate.anti.template.*.*(..))", returning="res")
	public void before(ResponseAbstract res){
		log.info(res.getMessage() + ":" + res.getStatusCode() );
		if (res.getStatusCode() == null) {
			return;
		}
	errorHandler.handle(res);
	}

}
