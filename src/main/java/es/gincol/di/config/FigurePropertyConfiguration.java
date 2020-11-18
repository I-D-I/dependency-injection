package es.gincol.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:area.properties")
public class FigurePropertyConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertiesConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
