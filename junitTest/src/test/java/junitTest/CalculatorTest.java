package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junitTest.Problem.Calculator;

public class CalculatorTest {
	private Calculator calculator;
	
	@BeforeEach
	public void setUp() {
		Problem problem = new Problem();
		this.calculator = problem.new Calculator(3); // init c = 3
	}

	@Test
	public void testAddition() {
		int actResult = calculator.sum(1,2);
		// 1 + 2 + 3  = 6
		int expResult = 6;
		assertEquals(expResult, actResult);
	}
	
	@Test
	public void testSubtraction() {
		int actResult = calculator.subtract(3,2);
		// 3 - 2 - 3= -2
		int expResult = -2;
		assertEquals(expResult, actResult);
	}
}