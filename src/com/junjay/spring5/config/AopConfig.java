package com.junjay.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.junjay.spring5"})
// @EnableAspectJAutoProxy  ����aspectj ���ɴ������ Ĭ��Ϊfalse 
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {

}
