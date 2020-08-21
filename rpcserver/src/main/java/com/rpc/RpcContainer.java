/**
 * 文件名称:          	RpcContainer
 * 版权所有@ 2019-2020 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册中心
 * <p>
 * Version  1.0.0
 *
 * @author yq.song
 * <p>
 * Date     2020/8/21 10:54
 */

public class RpcContainer {
	
	
	private Map<String, BeanMethod> publishMethods =new ConcurrentHashMap<String, BeanMethod>();
	
	private volatile static RpcContainer rpcContainer;
	
	private RpcContainer(){}
	
	public static RpcContainer getInstance(){
		if(rpcContainer==null){
			synchronized (RpcContainer.class){
				if(rpcContainer==null){
					rpcContainer=new RpcContainer();
				}
			}
		}
		return rpcContainer;
	}
	
	public void addRpcMethod(String key,BeanMethod beanMethod){
		publishMethods.put(key,beanMethod);
	}
	
	//根据客户端调用逻辑，从注册中心获取注册服务，调用方法，返回执行结果
	public Object process(RpcObject rpcObject){
		
		String key=rpcObject.getClassName()+"."+rpcObject.getMethodName();
		
		BeanMethod beanMethod= publishMethods.get(key);
		
		if(beanMethod==null){
			return "cat not find the service method!!";
		}
		
		try {
			return beanMethod.getMethod().invoke(beanMethod.getBean(),rpcObject.getArgs());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
