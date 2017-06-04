package com.contaazul.model;

import java.io.Serializable;

import com.contaazul.simulators.components.BlueRobotOrientationEnum;

/**
 * Registrar a posição e orientação atual do BlueRobot
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
public class BlueRobotCurrentPosition implements Serializable {
	private static final long serialVersionUID = 1L;
	private int x,y;
	private BlueRobotOrientationEnum orientationEnum;

	/**
	 * Posicionar o BlueRobot na posição e orientação padrão.
	 */
	public BlueRobotCurrentPosition() {
		this.x = 0;
		this.y = 0;
		this.orientationEnum = BlueRobotOrientationEnum.NORTH;
	}
	
	/**
	 * Posicionar o BlueRobot conforme parâmetros abaixo:
	 */
	public BlueRobotCurrentPosition(int x, int y, BlueRobotOrientationEnum orientationEnum) {
		this.x = x;
		this.y = y;
		this.orientationEnum = orientationEnum;
	}
	
	public BlueRobotOrientationEnum getOrientationEnum() {
		return orientationEnum;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	/**
	 * Considerar a posicão do BlueRobot na comparação.   
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof BlueRobotCurrentPosition))
			return false;
		BlueRobotCurrentPosition compare = (BlueRobotCurrentPosition)obj;
		return (compare.x == this.x) && ( compare.y == this.y) && (compare.orientationEnum.equals(this.orientationEnum));	
	}
	
	@Override
	public String toString() {
		return String.format("(%s,%s,%s)", x, y,  orientationEnum.toString() );
	}
	
	public void setOrientationEnum(BlueRobotOrientationEnum orientationEnum) {
		this.orientationEnum = orientationEnum;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
