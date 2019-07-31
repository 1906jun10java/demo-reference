package com.revature.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
//@Scope(value="prototype")
// for prototype-scoped beans, container stops managing the lifecycle when bean is ready to use
// so! destroy(), custom destroy methods are not called by AC
public class LifecycleBean implements InitializingBean, DisposableBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set from InitializingBean");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy from DisposableBean");
	}
	
	public void defaultInit() {
		System.out.println("custom init method");
	}
	
	public void defaultDestroy() {
		System.out.println("custom destroy method");
	}

}
