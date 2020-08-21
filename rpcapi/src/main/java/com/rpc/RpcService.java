/**
 * 文件名称:          	RpcService
 * 版权所有@ 2017-2018 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

/**
 * TODO: 文件注释
 * <p>
 * Version		1.0.0
 *
 * @author yq.song
 * <p>
 * Date	      2020/8/21 10:36
 */
public interface RpcService {
	
	User addUser(User user);
	
	String testUser(User user);
}

