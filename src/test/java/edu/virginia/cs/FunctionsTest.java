package edu.virginia.cs;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FunctionsTest {

	@Test
	void test() {
		String[] args = {"1", "9"};
		Functions.main(args);
	}
	
	@Test
	void testSum() {
		double r = Functions.sum(1, 9);
		assertEquals(10.0, r, 1e-10);
	}
	
	@Test
	void testProduct() {
		double r = Functions.product(1, 9);
		assertEquals(9.0, r, 1e-10);
	}

}
