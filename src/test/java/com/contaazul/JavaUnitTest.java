package com.contaazul;

import org.junit.Assert;
import org.junit.Test;

import com.contaazul.BlueRobotExceptions.BlueRobotInvalidCommandException;
import com.contaazul.simulators.components.BlueRobotCommandEnum;
import com.contaazul.simulators.components.BlueRobotOrientationEnum;

/**
 * Implementar todos os testes unitário da aplicação.
 * 
 * @author Breno Marques
 * @since V1.0.0
 */
public class JavaUnitTest {

	@Test
	public void blueRobotCommandEnumParseCommands() throws BlueRobotInvalidCommandException {
		Assert.assertEquals("BlueRobotCommandEnumParseCommands", BlueRobotCommandEnum.parseCommands("MLR").length, 3);
	}
	
	@Test(expected = BlueRobotInvalidCommandException.class)
	public void blueRobotCommandEnumParseCommandsException() throws BlueRobotInvalidCommandException {
		BlueRobotCommandEnum.parseCommands("A");
	}
	
	@Test(expected = BlueRobotInvalidCommandException.class)
	public void blueRobotCommandEnumParseCommandsExceptionEmpty() throws BlueRobotInvalidCommandException {
		BlueRobotCommandEnum.parseCommands(" ");
	}
	
	@Test
	public void blueRobotOrientationEnumGet90DegreesLeft() throws BlueRobotInvalidCommandException {
		Assert.assertEquals(BlueRobotOrientationEnum.NORTH, BlueRobotOrientationEnum.EAST.get90DegreesLeft());
		Assert.assertEquals(BlueRobotOrientationEnum.WEST, BlueRobotOrientationEnum.NORTH.get90DegreesLeft());
		Assert.assertEquals(BlueRobotOrientationEnum.SOUTH, BlueRobotOrientationEnum.WEST.get90DegreesLeft());
		Assert.assertEquals(BlueRobotOrientationEnum.EAST, BlueRobotOrientationEnum.SOUTH.get90DegreesLeft());
	}
	
	@Test
	public void blueRobotOrientationEnumGet90DegreesRight() throws BlueRobotInvalidCommandException {
		Assert.assertEquals(BlueRobotOrientationEnum.NORTH, BlueRobotOrientationEnum.WEST.get90DegreesRight());
		Assert.assertEquals(BlueRobotOrientationEnum.WEST, BlueRobotOrientationEnum.SOUTH.get90DegreesRight());
		Assert.assertEquals(BlueRobotOrientationEnum.SOUTH, BlueRobotOrientationEnum.EAST.get90DegreesRight());
		Assert.assertEquals(BlueRobotOrientationEnum.EAST, BlueRobotOrientationEnum.NORTH.get90DegreesRight());
	}
	

}
