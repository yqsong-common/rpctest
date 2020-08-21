/**
 * 文件名称:          	Rpc
 * 版权所有@ 2019-2020 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * TODO: 文件注释
 * <p>
 * Version  1.0.0
 *
 * @author yq.song
 * <p>
 * Date     2020/8/21 10:47
 */
@Component
public class RpcPublish implements BeanPostProcessor {
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//当bean被自定义rpc服务注解修饰时，自动发布服务
		if(bean.getClass().isAnnotationPresent(MyRpcService.class)){
			
			for (Method method : bean.getClass().getMethods()) {
				String key= bean.getClass().getInterfaces()[0].getSimpleName()+"."+method.getName();
				RpcContainer rpcContainer=RpcContainer.getInstance();
				rpcContainer.addRpcMethod(key,new BeanMethod(bean,method));
			}
		}
		
		return bean;
	}
}
