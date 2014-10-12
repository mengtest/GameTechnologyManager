package com.gametech.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于防止重复提交的token
 * @author guangshuai.wang
 * @date:2014-9-21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
	boolean NeedToken() default false;
	boolean RemoveToken() default false;
}
