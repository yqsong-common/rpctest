/**
 * 文件名称:          	RpcSocketServer
 * 版权所有@ 2019-2020 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * TODO: 文件注释
 * <p>
 * Version  1.0.0
 *
 * @author yq.song
 * <p>
 * Date     2020/8/21 11:45
 */

@Component
public class RpcSocketServer implements ApplicationListener<ContextRefreshedEvent> {
	
	ExecutorService executorService=Executors.newCachedThreadPool();
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		try(ServerSocket serverSocket=new ServerSocket(8888)) {
			//启动socket服务端,用于rpc调用
			while (true){
				Socket socket=serverSocket.accept();
				executorService.execute(new RpcServerHandler(socket));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
