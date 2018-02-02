package com.loveboy.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.loveboy.commons.YHFunction;

@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceLogInfo {
	/*
	 * 方法模块名称
	 */
	String moduleName() default "";
	/*
	 * 方法逻辑描述
	 */
	String description() default "";
	
	/*
	 * 功能id，用于统计功能使用率
	 */
	YHFunction function() default YHFunction.none;
}
