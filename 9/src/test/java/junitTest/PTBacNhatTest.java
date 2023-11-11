package junitTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PTBacNhatTest {
	@Test
	void test_1() {
		int a = 0;
		int b = 100;
		double actResult = Problem.ptbacnhat(a, b);
		double expResult = Double.MIN_VALUE;
		assertEquals(expResult, actResult);
	}
	
	@Test
	void test_2() {
		int a = 0;
		int b = 0;
		double actResult = Problem.ptbacnhat(a, b);
		double expResult = Double.MAX_VALUE;
		assertEquals(expResult, actResult);
	}

	@Test
	void test_3() {
		int a = 2;
		int b = 4;
		double actResult = Problem.ptbacnhat(a, b);
		double expResult = -2;
		assertEquals(expResult, actResult);
	}

}
