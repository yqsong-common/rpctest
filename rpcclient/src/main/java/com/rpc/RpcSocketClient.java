/**
 * 文件名称:          	RpcSocketClient
 * 版权所有@ 2019-2020 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 创建bean过程之前，将包含特定注解的类，用动态代理对象替换
 * <p>
 * Version  1.0.0
 *
 * @author yq.song
 * <p>
 * Date     2020/8/21 14:57
 */
@Component
public class RpcSocketClient implements BeanPostProcessor {
	
	
	//在bean初始化之前，如果field被rpc注解修饰，那么用动态代理类，注入该属性。
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		Class clazz=bean.getClass();
		
		Field[] fields=clazz.getDeclaredFields();
		
		for (Field field : fields) {
			if(field.isAnnotationPresent(MyRpcAutowired.class)){
				field.setAccessible(true);
				try {
					field.set(bean,new RpcProxy().getInstance(field));
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return bean;
	}
}
