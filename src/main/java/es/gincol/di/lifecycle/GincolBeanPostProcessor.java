package es.gincol.di.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class GincolBeanPostProcessor implements BeanPostProcessor {

	
	private static final Logger log = LoggerFactory.getLogger(GincolBeanPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.info("Before initializacion {}", beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.info("After initializacion {}", beanName);
		return bean;
	}

	
}
