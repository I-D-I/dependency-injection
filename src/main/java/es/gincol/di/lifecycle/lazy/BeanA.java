package es.gincol.di.lifecycle.lazy;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanA {

	private static final Logger log = LoggerFactory.getLogger(BeanA.class);

	@Autowired
	private BeanB beanB;
	
	@PostConstruct
	public void init() {
		log.info("init bean a");
	}
}
