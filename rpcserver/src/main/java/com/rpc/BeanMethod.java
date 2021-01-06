/**
 * 文件名称:          	BeanMethod
 * 版权所有@ 2019-2020 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

import java.lang.reflect.Method;

/**
 * TODO: 文件注释
 * <p>
 * Version  1.0.0
 *
 * @author yq.song
 * <p>
 * Date     2020/8/21 14:34
 */
public class BeanMethod {
	
	private Object bean;
	
	private Method method;
	
	public BeanMethod(Object bean, Method method) {
		this.bean = bean;
		this.method = method;
		
	}
	
	public Object getBean() {
		return bean;
	}
	
	public void setBean(Object bean) {
		this.bean = bean;
	}
	
	public Method getMethod() {
		return method;
	}
	
	public void setMethod(Method method) {
		this.method = method;
	}
}
