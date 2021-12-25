package com.junjay.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// ��Ϊ�����࣬���xml�����ļ���
@Configuration
// ɨ����Щ���µ�ע��
// ��ͬ��xml�����ļ��У�<context:component-scan base-package="com.junjay.spring5"></context:component-scan>
// �����ļ�������Ϊ context�������ģ�component-scan��ɨ�����base-package��ɨ���·��
// ��Ӧ��ϵ��context����@Configuration component-scan����@ComponentScan��base-package����basePackages =�����顯
// @Configuration�����˸����������࣬@ComponentScan ɨ��� basePackages={"com.junjay.spring5"} ɨ����Щ·����ע��
// ��׻�����@Configuration���ε����������࣬����ɨ�����ɨ��com.junjay.spring5�µ�ע��
@ComponentScan(basePackages = { "com.junjay.spring5", "" })
public class SpringConfig {

}
