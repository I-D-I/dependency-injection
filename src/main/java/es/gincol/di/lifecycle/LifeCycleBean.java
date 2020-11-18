package es.gincol.di.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
//@Scope("prototype") --Recordemos que predestroy no se ejecuta para beans de tipo prototype
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {

	
	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

	/**
	 * Se ejecuta en la construcción del bean
	 */
	@Override
	public void setBeanName(String name) {
		log.info("Bean name aware {}", name);
	}

	/**
	 * Se ejecuta después de la inección de dependencias
	 */
	@PostConstruct
	public void init() {
		log.info("Post construct");
	}
	
	/**
	 * Se ejecuta antes de que el bean sea destruido
	 * No se ejecutan para beans pototype
	 * Solo se ejecutan si se finaliza la JVM de forma normal
	 */
	@PreDestroy
	public void destory() {
		log.info("Pre destroy");
	}

	
	@Override
	public void destroy() throws Exception {
		log.info("Destroy method");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("After properties set method");
	}
}
