/**
 * 文件名称:          	RpcServiceImpl
 * 版权所有@ 2019-2020 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

/**
 * 对外提供远程服务
 * <p>
 * Version  1.0.0
 *
 * @author yq.song
 * <p>
 * Date     2020/8/21 10:35
 */
@MyRpcService
public class RpcServiceImpl implements RpcService{
	
	@Override
	public User addUser(User user) {
		
		System.out.println("新增用户信息："+user.toString());
		user.setAge(55);
		return user;
	}
	
	@Override
	public String testUser(User user) {
		
		System.out.println("测试用户信息："+user.toString());
		return "success";
	}
}
