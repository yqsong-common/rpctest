/**
 * 文件名称:          	MyRpcService
 * 版权所有@ 2017-2018 	易鑫集团，保留所有权利
 * 编译器:           	JDK1.8
 */

package com.rpc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * TODO: 文件注释
 * <p>
 * Version		1.0.0
 *
 * @author yq.song
 * <p>
 * Date	      2020/8/21 10:45
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface MyRpcService {
}
