package es.gincol.di.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure {

//	@Value("2.5")
	@Value("${square.side}")
	private double side;
	
	@Override
	public double calculateArea() {
		return side*side;
	}

}
