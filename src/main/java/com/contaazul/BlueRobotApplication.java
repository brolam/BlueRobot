package com.contaazul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.contaazul.controller.BlueRobotConnectionController;

/**
 * Executar a aplicação e iniciar o controle
 * {@link BlueRobotConnectionController}
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.contaazul.controller" })
public class BlueRobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueRobotApplication.class, args);
	}
}
