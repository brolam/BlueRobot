package com.contaazul.simulators.components;

import com.contaazul.BlueRobotExceptions;
import com.contaazul.BlueRobotExceptions.BlueRobotPositionException;
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

	/**
	 * Construir um BlueRobot no posicionamento padrão.  
	 */
	public BlueRobot(IUniversalPositioningSystem iUPS) {
		this.currentPosition = new BlueRobotCurrentPosition();
		this.iUPS = iUPS;
	}

	/**
	 * Construir um BlueRobot informando o posicionamento e orientação.  
	 */
	public BlueRobot(int x, int y, BlueRobotOrientationEnum orientationEnum) {
		this.currentPosition = new BlueRobotCurrentPosition(x, y, orientationEnum);
		this.iUPS = null;
	}
	
	public BlueRobotCurrentPosition getCurrentPosition() {
		return currentPosition;
	}

	public void set90DegreesLeft() {
		BlueRobotOrientationEnum newOrientation = getCurrentPosition().getOrientationEnum().get90DegreesLeft();
		getCurrentPosition().setOrientationEnum(newOrientation);		
	}

	public void set90DegreesRight() {
		BlueRobotOrientationEnum newOrientation = getCurrentPosition().getOrientationEnum().get90DegreesRight();
		getCurrentPosition().setOrientationEnum(newOrientation);		
	
		
	}

	/**
	 * Movimentar o BlueRobot uma posição conforme a {@link BlueRobotOrientationEnum} atual. 
	 * @throws BlueRobotPositionException
	 */
	public void moveOnePosition() throws BlueRobotPositionException {
		switch (getCurrentPosition().getOrientationEnum()) {
		case NORTH:
			moveBetweenNothAndSouth(1);
			break;
		case SOUTH:
			moveBetweenNothAndSouth(-1);
			break;
		case EAST:
			moveBetweenWestAndEast(1);
			break;
		case WEST:
			moveBetweenWestAndEast(-1);
			break;
		}
	}
	
	/**
	 * Verificar se o sistema de navegação {@link IUniversalPositioningSystem} do BlueRobot está online
	 *  para permitir a movimentação.
	 * @throws BlueRobotPositionException
	 */
	private void parseUPS() throws BlueRobotPositionException{
		if (this.iUPS == null) {
			throw new BlueRobotExceptions.BlueRobotPositionException(
					"Global Positioning System is offline, you can not move BlueRobot.");
		}
	}
	
	/**
	 * Movimentar o BlueRobot entre o West e East.
	 * @param step informar um valor negativo para movimentar para o West e positivo para East.
	 * @throws BlueRobotPositionException
	 */
	private void moveBetweenWestAndEast(int step) throws BlueRobotPositionException{
		parseUPS();
		int x = getCurrentPosition().getX() + step;
		if ( ( x < 0 ) || ((x) > iUPS.getLimitAreaX() )) {
			throw new BlueRobotExceptions.BlueRobotPositionException(
					String.format("Invalid position (x:%s) is not between 0 and %s", x, iUPS.getLimitAreaX()));
		} else {
			getCurrentPosition().setX(x);
		}
	}
	
	/**
	 * Movimentar o BlueRobot entre o Noth e South.
	 * @param step informar um valor negativo para movimentar para o South e positivo para Noth.
	 * @throws BlueRobotPositionException
	 */
	private void moveBetweenNothAndSouth(int step) throws BlueRobotPositionException{
		parseUPS();
		int y = getCurrentPosition().getY() + step;
		if ( ( y < 0 ) || ((y) > iUPS.getLimitAreaY() )) {
			throw new BlueRobotExceptions.BlueRobotPositionException(
					String.format("Invalid position (y:%s) is not between 0 and %s", y, iUPS.getLimitAreaY()));
		} else {
			getCurrentPosition().setY(y);
		}
	}
}
