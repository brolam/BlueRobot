package com.contaazul.simulators.components;

/**
 * Implementar às regras para definir uma orientação válida para o BlueRobot.
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
public enum BlueRobotOrientationEnum {
	NORTH, EAST, SOUTH, WEST;

	/**
	 * Recuperar a próxima orientação 90 gráus a esquerdas
	 */
	public BlueRobotOrientationEnum get90DegreesLeft() {
		int previousOrientation = this.ordinal() -1;
		if (previousOrientation < 0 ){
			return WEST;
		} else {
			return values()[previousOrientation];
		}
	}

	/**
	 * Recuperar a próxima orientação 90 gráus a direita
	 */
	public BlueRobotOrientationEnum get90DegreesRight() {
		int nextOrientation = this.ordinal() + 1;
		if (nextOrientation >= values().length ){
			return NORTH;
		} else {
			return values()[nextOrientation];
		}
	}

	@Override
	public String toString() {
		return super.toString().substring(0, 1);
	}
}
