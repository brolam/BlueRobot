package com.contaazul.simulators.components;

import com.contaazul.BlueRobotExceptions.BlueRobotInvalidCommandException;

/**
 * Implementar às regras para definir um comando válido para o BlueRobot.
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
public enum BlueRobotCommandEnum {
	LEFT, RIGHT, MOVE,;

	/**
	 * Analisar os comandos informados em um texto.
	 * @param commands informar um texto com comandos válidos em sequência.
	 * @return uma lista de comandos válidos.
	 * @throws BlueRobotInvalidCommandException;
	 */
	public static BlueRobotCommandEnum[] parseCommands(String commands) throws BlueRobotInvalidCommandException  {
		// TODO BlueRobotCommandEnum
		return null;
	}
}
