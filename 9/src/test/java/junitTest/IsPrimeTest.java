package junitTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class IsPrimeTest {
	@Test
	void test1() {
		int a=-1;
		boolean actResult= Problem.isPrime(a);
		assertFalse(actResult);
	}
	@Test
	void test2() {
		int a=0;
		boolean actResult= Problem.isPrime(a);
		assertFalse(actResult);
	}
	@Test
	void test3() {
		int a=2;
		boolean actResult= Problem.isPrime(a);
		assertTrue(actResult);
	}
	@Test
	void test4() {
		int a=6;
		boolean actResult= Problem.isPrime(a);
		assertFalse(actResult);
	}

}
