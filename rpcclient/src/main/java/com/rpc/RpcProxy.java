/**
 * 文件名称:          	RpcProxy
 * 版权所有@ 2019-2020 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * TODO: 文件注释
 * <p>
 * Version  1.0.0
 *
 * @author yq.song
 * <p>
 * Date     2020/8/21 15:04
 */
public class RpcProxy implements InvocationHandler {
	
	private Field field;
	
	
	public Object getInstance(Field field){
		this.field=field;
		Object proxy=Proxy.newProxyInstance(field.getType().getClassLoader(),new Class[]{field.getType()},this);
		return proxy;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//动态代理的方法执行时，通过socket，调用远程方法执行
		RpcObject rpcObject=new RpcObject();
		rpcObject.setClassName(field.getType().getSimpleName());
		rpcObject.setMethodName(method.getName());
		rpcObject.setArgs(args);
		
		Socket socket=new Socket("localhost",8888);
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
		objectOutputStream.writeObject(rpcObject);
		objectOutputStream.flush();
		
		ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
		Object object =objectInputStream.readObject();
		
		
		return object;
	}
}
