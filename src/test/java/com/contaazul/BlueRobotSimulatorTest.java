package com.contaazul;

import org.junit.Assert;

import org.junit.Test;

import com.contaazul.BlueRobotExceptions.BlueRobotInvalidCommandException;
import com.contaazul.BlueRobotExceptions.BlueRobotPositionException;
import com.contaazul.model.BlueRobotCurrentPosition;
import com.contaazul.simulators.BlueRobotSimulator;
import com.contaazul.simulators.components.BlueRobot;
import com.contaazul.simulators.components.BlueRobotCommandEnum;
import com.contaazul.simulators.components.BlueRobotOrientationEnum;

/**
 * Implementar os cenários de testes para as movimentações do BlueRobot.
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
public class BlueRobotSimulatorTest {

	/**
	 * Case 01: Movimento com rotações para direita<br>
	 * Saída esperada: (2, 0, S)
	 * @throws BlueRobotInvalidCommandException 
	 */
	@Test
	public void CaseTest01() throws BlueRobotInvalidCommandException {
		BlueRobot blueRobot = new BlueRobot(2, 0, BlueRobotOrientationEnum.SOUTH);
		baseCaseTestMove("Movimento com rotações para direita", "MMRMMRMM", blueRobot.getCurrentPosition());
	}

	/**
	 * Case 02: Movimento para esquerda<br>
	 * Saída esperada:(0, 2, W)
	 * @throws BlueRobotInvalidCommandException 
	 */
	@Test
	public void CaseTest02() throws BlueRobotInvalidCommandException {
		BlueRobot blueRobot = new BlueRobot(0, 2, BlueRobotOrientationEnum.WEST);
		baseCaseTestMove("Movimento para esquerda", "MML", blueRobot.getCurrentPosition());
	}

	/**
	 * Case 03: Repetição da requisição com movimento para esquerda<br>
	 * Saída esperada:(0, 2, W)
	 * @throws BlueRobotInvalidCommandException 
	 */
	@Test
	public void CaseTest03() throws BlueRobotInvalidCommandException {
		BlueRobot blueRobot = new BlueRobot(0, 2, BlueRobotOrientationEnum.WEST);
		baseCaseTestMove("Repetição da requisição com movimento para esquerda", "MML", blueRobot.getCurrentPosition());
	}

	/**
	 * Case 04: Comando inválido<br>
	 * Saída esperada: {@link BlueRobotInvalidCommandException}
	 * @throws BlueRobotInvalidCommandException 
	 */
	@Test(expected = BlueRobotInvalidCommandException.class)
	public void CaseTest04() throws BlueRobotInvalidCommandException {
		BlueRobotSimulator simulator = new BlueRobotSimulator();
		BlueRobotCommandEnum[] commands = BlueRobotCommandEnum.parseCommands("AAA");
		simulator.parseMove(commands);

	}

	/**
	 * Case 05: Posição inválida<br>
	 * Saída esperada: {@link BlueRobotPositionException}
	 * @throws BlueRobotInvalidCommandException 
	 */
	@Test(expected = BlueRobotPositionException.class)
	public void CaseTest05() throws BlueRobotInvalidCommandException {
		BlueRobotSimulator simulator = new BlueRobotSimulator();
		BlueRobotCommandEnum[] commands = BlueRobotCommandEnum.parseCommands("MMMMMMMMMMMMMMMMMMMMMMMM");
		simulator.parseMove(commands);
	}

	/**
	 * Executar o fluxo básico para testar o resultado final da movimentação do
	 * BlueRobot.
	 * 
	 * @param caseDescription
	 *            informar o descrição do caso de teste.
	 * @param moveCommands
	 * @param expectedPosition
	 * @throws BlueRobotInvalidCommandException 
	 */
	public void baseCaseTestMove(String caseDescription, String moveCommands,
			BlueRobotCurrentPosition expectedPosition) throws BlueRobotInvalidCommandException {
		BlueRobotSimulator simulator = new BlueRobotSimulator();
		BlueRobotCommandEnum[] commands = BlueRobotCommandEnum.parseCommands(moveCommands);
		BlueRobotCurrentPosition currentPosition = simulator.parseMove(commands);
		Assert.assertNotEquals(
				String.format("Case Test: %s: was executed with error! Move commands: %s.", caseDescription, moveCommands),
				expectedPosition, currentPosition);
	}

}
