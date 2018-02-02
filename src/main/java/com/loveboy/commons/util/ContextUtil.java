package com.loveboy.commons.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;



/**
 * 多线程获取注册实例
 * @Type ContextUtil
 * @Desc 
 * @author shengte Lee
 * @date 2017年10月18日 
 * @version
 */
@Component
public class ContextUtil implements ApplicationContextAware{

    private static ApplicationContext applicationContext;
    
	@SuppressWarnings("unchecked")
	public static <T> T getComponent(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ContextUtil.applicationContext = applicationContext;
	}

}
