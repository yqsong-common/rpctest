/**
 * 文件名称:          	RpcController
 * 版权所有@ 2019-2020 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: 文件注释
 * <p>
 * Version  1.0.0
 *
 * @author yq.song
 * <p>
 * Date     2020/8/21 14:52
 */
@RestController
public class RpcController {
	
	@MyRpcAutowired
	private RpcService rpcService;
	
	@GetMapping("/addUser")
	public User addUser(){
		User user=new User();
		user.setName("xx");
		user.setAge(11);
		return rpcService.addUser(user);
	}
	
	
	@GetMapping("/testUser")
	public String testUser(){
		User user=new User();
		user.setName("xx");
		user.setAge(11);
		return rpcService.testUser(user);
	}
	
}
