package junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class FindMinTest {

	@Test
	void testFindMin1() {
		int a = 1;
		int b = 2;
		int c = 3;
		int actResult = Problem.findMin(a, b, c);
		int expResult = 1;
		assertEquals(expResult, actResult);
	}

	@Test
	void testFindMin2() {
		int a = 5;
		int b = 2;
		int c = 8;
		int actResult = Problem.findMin(a, b, c);
		int expResult = 2;
		assertEquals(expResult, actResult);
	}

	@Test
	void testFindMin3() {
		int a = 5;
		int b = 2;
		int c = 0;
		int actResult = Problem.findMin(a, b, c);
		int expResult = 0;
		assertEquals(expResult, actResult);
	}

	@Test
	void testFindMin4() {
		int a = 2;
		int b = 4;
		int c = 1;
		int expResult = 1;
		int actResult = Problem.findMin(a, b, c);
		assertEquals(expResult, actResult);
	}

}
