package com.contaazul.simulators.components;

/**
 * Para sobreviver em Marte, o BlueRobot vai precisar de um UPS( universal
 * positioning system ) para definir a área limite onde o BlueRobot pode se
 * movimentar.<br>
 * Sendo assim, será necessário fornecer esse sistema de navegação antes de
 * movimentar o BlueRobot.
 * 
 * @author Breno Marques
 * @since V1.0.0
 */

public interface IUniversalPositioningSystem {
	int getLimitAreaX();

	int getLimitAreaY();
}
