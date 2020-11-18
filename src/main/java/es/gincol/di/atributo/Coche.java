package es.gincol.di.atributo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Coche {

	@Value("Seat")
	private String marca;
	@Value("2010")
	private Integer modelo;
	
//	@Autowired
	private Motor motor;

	public Coche() {

	}

//	@Autowired
//	public Coche(@Value("Seat") String marca, @Value("2010") Integer modelo, Motor motor) {
//		super();
//		this.marca = marca;
//		this.modelo = modelo;
//		this.motor = motor;
//	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	public Motor getMotor() {
		return motor;
	}

	@Autowired
	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
	}

}
