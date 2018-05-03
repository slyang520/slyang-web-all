//package cn.slyang.service.sso.shiro;
//
//import org.apache.shiro.realm.Realm;
//import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
//import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created by slyang on 17/6/21.
// */
//@Configuration
//public class ShiroConfig {
//
//	//	 @see: http://www.cppblog.com/guojingjia2006/archive/2014/05/14/206956.html
//	//	 package org.apache.shiro.spring.config.web.autoconfigure;
//	@Bean
//	protected ShiroFilterChainDefinition shiroFilterChain() {
//
//		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
//		//  可匿名访问
//		//  静态资源
//		chainDefinition.addPathDefinition("/css/**", "anon");
//		chainDefinition.addPathDefinition("/js/**", "anon");
//		chainDefinition.addPathDefinition("/image/**", "anon");
//		chainDefinition.addPathDefinition("/favicon.ico", "anon");
//		//  登录页，登录接口
//		chainDefinition.addPathDefinition("/login", "anon");
//		chainDefinition.addPathDefinition("/manage/**", "anon");
//		chainDefinition.addPathDefinition("/**", "authc");
//
//		return chainDefinition;
//	}
//
//	@Bean
//	public Realm MyRealm() {
//		return new JDBCRealm();
//	}
//
//
//}