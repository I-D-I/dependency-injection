package es.gincol.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import es.gincol.di.atributo.Coche;
import es.gincol.di.autowire.AreaCalculatorService;
import es.gincol.di.lifecycle.ExplicitBean;
import es.gincol.di.lifecycle.LifeCycleBean;
import es.gincol.di.profiles.EnvironmentService;
import es.gincol.di.qualifiers.Animal;
import es.gincol.di.qualifiers.Avion;
import es.gincol.di.qualifiers.Nido;
import es.gincol.di.qualifiers.Pajaro;
import es.gincol.di.qualifiers.Perro;
import es.gincol.di.scopes.EjemploScopeService;

@SpringBootApplication
public class DependencyInjectionApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

	@Bean
	public String getApplicationName() {
		return "¡mi aplicación!";
	}
	
	@Bean
	public String getOtro() {
		return "¡otra aplicación!";
	}

//	@Bean(initMethod = "init", destroyMethod = "destroy")
//	public ExplicitBean getBean() {
//		return new ExplicitBean();
//	}
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		
 		Coche coche = context.getBean(Coche.class);
 		
//		Motor motor = new Motor("Xl1", 1981);
//		Coche coche = new Coche("VW", 1986, motor);
	
 		log.info(coche.toString());
 		
 		Perro perro = context.getBean(Perro.class);
 		log.info("Objeto {}", perro.getNombre());

 		Pajaro pajaro = context.getBean(Pajaro.class);
 		log.info("Objeto {}", pajaro.getNombre());

 		Avion avion = context.getBean(Avion.class);
 		avion.volar();
 		
 		Animal animal1 = context.getBean("pajaro", Animal.class);
 		log.info("Animal nombre = {}, edad = {}", animal1.getNombre(), animal1.getEdad());
 		
 		Animal animal2 = context.getBean("perro", Animal.class);
 		log.info("Animal nombre = {}, edad = {}", animal2.getNombre(), animal2.getEdad());
 		
 		Nido nido = context.getBean(Nido.class);
 		nido.imprimir();
 		
 		EnvironmentService environmentService = context.getBean(EnvironmentService.class);
 		log.info("Active environment {}", environmentService.getEnvironment());
 		
 		EjemploScopeService ejemploScoperService1 = context.getBean(EjemploScopeService.class);
 		EjemploScopeService ejemploScoperService2 = context.getBean(EjemploScopeService.class);
 		log.info("Son equals {}", ejemploScoperService1.equals(ejemploScoperService2));
 		log.info("Son == {}", ejemploScoperService1 == ejemploScoperService2);
 		
 		String nombreAplicacion = context.getBean("getOtro", String.class);
 		log.info("Nombre aplicación {}", nombreAplicacion);
 		
  		AreaCalculatorService calculator = context.getBean(AreaCalculatorService.class);
  		log.info("Area total {}", calculator.calcAreas());
  		
  		//SPEL
  		ExpressionParser parser = new SpelExpressionParser();
  		Expression parseExpression = parser.parseExpression("10+20");
  		log.info("Result {}", parseExpression.getValue());
  		
  		LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);
  		
 		
	}

}
