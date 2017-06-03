package com.contaazul.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contaazul.BlueRobotExceptions;
import com.contaazul.BlueRobotExceptions.BlueRobotPositionException;
import com.contaazul.model.BlueRobotCurrentPosition;

/**
 * Controlar o recebimento e envio dos comandos para executar a movimentação do
 * BlueRobot.
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
@RestController
public class BlueRobotConnectionController {

	/**
	 * Transmitir os comandos para movimentar o BlueRobot.
	 * 
	 * @param command
	 *            Informar os comandos conforme regras abaixo: <br>
	 *            L - Rotacionar o BlueRobot em seu próprio eixo 90 graus para esquerda; <br>
	 *            R - Rotacionar o BlueRobot em seu próprio eixo 90 graus para direita; <br>
	 *            M - Movimentar o BlueRobot uma posição conforme a última orientação informada.<br>
	 *            Exemplo: MMRMMRMM
	 * @return {@link BlueRobotCurrentPosition} ou 
	 *         {@link HttpStatus.BAD_REQUEST} se ocorrer algum problema.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/rest/mars/{command}")
	public ResponseEntity<BlueRobotCurrentPosition> doMove(@PathVariable("command") String command) {
		try {
			throw new BlueRobotPositionException("Invalid Position");
		} catch (BlueRobotExceptions e) {
			return new ResponseEntity<BlueRobotCurrentPosition>(HttpStatus.BAD_REQUEST);
		}
	}

}
