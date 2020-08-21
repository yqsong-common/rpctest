/**
 * 文件名称:          	RpcObject
 * 版权所有@ 2019-2020 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

import java.io.Serializable;

/**
 * TODO: 文件注释
 * <p>
 * Version  1.0.0
 *
 * @author yq.song
 * <p>
 * Date     2020/8/21 12:04
 */
public class RpcObject implements Serializable {
	
	private String className;
	
	private String methodName;
	
	private Object[] args;
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public Object[] getArgs() {
		return args;
	}
	
	public void setArgs(Object[] args) {
		this.args = args;
	}
}
