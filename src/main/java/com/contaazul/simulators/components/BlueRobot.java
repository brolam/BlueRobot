package com.contaazul.simulators.components;

import com.contaazul.model.BlueRobotCurrentPosition;

/**
 * Implementar às regras para validar os comandos enviados ao BlueRobot.
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
public class BlueRobot {
	// Definir a posição e orientação atual do BlueRobot
	private BlueRobotCurrentPosition currentPosition;
	// Definir a área limite que o BlueRobot pode se movimentar.
	private IUniversalPositioningSystem iUPS;

	public BlueRobot(IUniversalPositioningSystem iUPS) {
		this.currentPosition = new BlueRobotCurrentPosition();
		this.iUPS = iUPS;
	}
}
