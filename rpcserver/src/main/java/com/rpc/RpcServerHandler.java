/**
 * 文件名称:          	RpcServerHandler
 * 版权所有@ 2019-2020 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * TODO: 文件注释
 * <p>
 * Version  1.0.0
 *
 * @author yq.song
 * <p>
 * Date     2020/8/21 11:57
 */
public class RpcServerHandler implements Runnable {
	
	private Socket socket;
	
	public RpcServerHandler(Socket socket){
		this.socket=socket;
	}
	
	@Override
	public void run() {
		
		try {
			
			InputStream inputStream=socket.getInputStream();
			ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
			//获取客户端传递的参数
			RpcObject rpcObject= (RpcObject) objectInputStream.readObject();
			//到注册中心，执行远程方法调用
			Object object=RpcContainer.getInstance().process(rpcObject);
			//将结果通过socket返回给客户端
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(object);
			objectOutputStream.flush();
			
			inputStream.close();
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
