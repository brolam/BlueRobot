package com.contaazul.simulators;

import com.contaazul.BlueRobotExceptions.BlueRobotPositionException;
import com.contaazul.model.BlueRobotCurrentPosition;
import com.contaazul.simulators.components.BlueRobot;
import com.contaazul.simulators.components.BlueRobotCommandEnum;
import com.contaazul.simulators.components.IUniversalPositioningSystem;

/**
 * Controlar o fluxo principal para realizar a simulação de movimentação do
 * BlueRobot.
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
public class BlueRobotSimulator implements IUniversalPositioningSystem {
	private static final int LIMIT_AREA_DEFAULT = 5;

	@Override
	public int getLimitAreaX() {
		return LIMIT_AREA_DEFAULT;
	}

	@Override
	public int getLimitAreaY() {
		return LIMIT_AREA_DEFAULT;
	}
	
	/**
	 * Analisar a mudança de posição do BlueRobot conforme uma lista de comandos.
	 * @param commands informar uma lista de comandos {@link BlueRobotCommandEnum}.
	 * @return
	 * @throws BlueRobotPositionException 
	 */
	public BlueRobotCurrentPosition parseMove(BlueRobotCommandEnum[] commandEnums) throws BlueRobotPositionException{
		//Iniciar BlueRobot na posição padrão:(0,0,N);  
		BlueRobot blueRobot = new BlueRobot(this);
		for(BlueRobotCommandEnum commandEnum: commandEnums){
			switch (commandEnum) {
			case LEFT:
				blueRobot.set90DegreesLeft();
				break;
			case RIGHT:
				blueRobot.set90DegreesRight();
				break;
			case MOVE:
				blueRobot.moveOnePosition();
				break;
			}
		}
		return blueRobot.getCurrentPosition();
	}

}
