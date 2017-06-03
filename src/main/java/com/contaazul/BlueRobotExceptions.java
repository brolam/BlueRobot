package com.contaazul;

/**
 * Definir as exceções para toda a aplicação
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
public abstract class BlueRobotExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public BlueRobotExceptions(String messageError) {
		super(messageError);
	}

	/**
	 * Sinalizar que não foi possível executar a movimentação do BlueRobot.
	 * 
	 * @author Breno Marques
	 * @since V1.0.0
	 */
	public static class BlueRobotPositionException extends BlueRobotExceptions {
		private static final long serialVersionUID = 1L;

		public BlueRobotPositionException(String messageError) {
			super(messageError);
		}
	}

	/**
	 * Sinalizar que o comando enviado para o BlueRobot é inválido.
	 * 
	 * @author Breno Marques
	 * @since V1.0.0
	 */
	public static class BlueRobotInvalidCommandException extends BlueRobotExceptions {
		private static final long serialVersionUID = 1L;

		public BlueRobotInvalidCommandException(String messageError) {
			super(messageError);
		}
	}
}
