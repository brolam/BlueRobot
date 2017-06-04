package com.contaazul.simulators.components;

import com.contaazul.BlueRobotExceptions.BlueRobotInvalidCommandException;

/**
 * Implementar às regras para definir um comando válido para o BlueRobot.
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
public enum BlueRobotCommandEnum {
	LEFT, RIGHT, MOVE;

	/**
	 * Analisar os comandos informados em um texto.
	 * 
	 * @param commands
	 *            informar um texto com comandos válidos em sequência.
	 * @return uma lista de comandos válidos.
	 * @throws BlueRobotInvalidCommandException;
	 */
	public static BlueRobotCommandEnum[] parseCommands(String commands) throws BlueRobotInvalidCommandException {
		if (commands == null || commands.isEmpty())
			throw new BlueRobotInvalidCommandException("The list of commands can not be empty.");
		BlueRobotCommandEnum[] commandEnums = new BlueRobotCommandEnum[commands.length()]; 
		int index = 0;
		for (char command : commands.toCharArray()) {
			commandEnums[index] = parseCommand(command);
			index++;
		}
		return commandEnums;
	}

	/**
	 * Analisar um comando informado em um carácter.
	 * @param command
	 * @throws BlueRobotInvalidCommandException
	 */
	public static BlueRobotCommandEnum parseCommand(char command) throws BlueRobotInvalidCommandException {
		for (BlueRobotCommandEnum commandEnum : BlueRobotCommandEnum.values()) {
			if (commandEnum.name().startsWith(String.valueOf(command)))
				return commandEnum;
		}
		throw new BlueRobotInvalidCommandException(String.format("The command %s is invalid", command));
	}
}
