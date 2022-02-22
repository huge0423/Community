package com.example.community;

import com.example.community.dao.testdao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//记住容器，便于其他地方使用
		this.applicationContext = applicationContext;
	}

	//测试是否获取到容器
	@Test
	public void testApplicationContext() {
		System.out.println(applicationContext);
		//使用容器  获取到bean，并得到其中的方法
		//不依赖bean本身，依赖他的接口，所以调用的不需要改变，只需要改变该接口下的bean，降低耦合度
		testdao testdao = applicationContext.getBean(com.example.community.dao.testdao.class);
		System.out.println(testdao.selectAll());
		//获取不是优先级的bean时
		//1.testdao = (testdao) applicationContext.getBean("testHibernate");
		//2.
		testdao = applicationContext.getBean("testHibernate", com.example.community.dao.testdao.class);
		System.out.println(testdao.selectAll());
	}
}
