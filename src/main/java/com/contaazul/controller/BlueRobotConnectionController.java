package com.contaazul.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.contaazul.BlueRobotExceptions;
import com.contaazul.model.BlueRobotCurrentPosition;
import com.contaazul.simulators.BlueRobotSimulator;
import com.contaazul.simulators.components.BlueRobotCommandEnum;

/**
 * Controlar o recebimento e envio dos comandos para executar a movimentação do
 * BlueRobot.
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
@RestController
public class BlueRobotConnectionController {
	private static final String MSG_BAD_REQUEST =  "400 Bad Request"; 

	/**
	 * Transmitir os comandos para movimentar o BlueRobot.
	 * 
	 * @param commands
	 *            Informar os comandos conforme regras abaixo: <br>
	 *            L - Rotacionar o BlueRobot em seu próprio eixo 90 graus para esquerda; <br>
	 *            R - Rotacionar o BlueRobot em seu próprio eixo 90 graus para direita; <br>
	 *            M - Movimentar o BlueRobot uma posição conforme a última orientação informada.<br>
	 *            Exemplo: MMRMMRMM Saída esperada: (2, 0, S)
	 * @return toString de {@link BlueRobotCurrentPosition}  ou 
	 *         {@link HttpStatus.BAD_REQUEST} se ocorrer algum error na movimentação.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/rest/mars/{commands}")
	public ResponseEntity<String> doMove(@PathVariable("commands") String commands) {
		try {
			BlueRobotSimulator robotSimulator = new BlueRobotSimulator();
			BlueRobotCommandEnum[] commandEnums = BlueRobotCommandEnum.parseCommands(commands);
			return new ResponseEntity<String>(robotSimulator.parseMove(commandEnums).toString(), HttpStatus.OK);
		} catch (BlueRobotExceptions e) {
			return new ResponseEntity<String>(MSG_BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}
	}

}
