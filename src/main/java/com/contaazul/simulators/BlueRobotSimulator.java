package com.contaazul.simulators;

import com.contaazul.model.BlueRobotCurrentPosition;
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

	@Override
	public int getLimitAreaX() {
		// TODO getLimitAreaX
		return 0;
	}

	@Override
	public int getLimitAreaY() {
		// TODO getLimitAreaY
		return 0;
	}
	
	/**
	 * Analisar a mudança de posicionamento do BlueRobot conforme uma lista de comandos.
	 * @param commands informar uma lista de comandos {@link BlueRobotCommandEnum}.
	 * @return
	 */
	public BlueRobotCurrentPosition parseMove(BlueRobotCommandEnum[] commands){
		// TODO BlueRobotCurrentPosition
		return null;
	}

}
