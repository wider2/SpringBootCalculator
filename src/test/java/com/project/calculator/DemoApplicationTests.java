package com.project.calculator;

import com.project.calculator.base.CalcType;
import com.project.calculator.base.FactoryOperation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void testMultiply() throws Exception  {
		double dblFirst = -2;
		double dblSecond = 2;
		double result = FactoryOperation.makeOperation(CalcType.MULTIPLY, dblFirst, dblSecond);

		assertEquals(-4, result);
	}

	@Test
	void testMultiplyTo0() throws Exception  {
		double dblFirst = 2;
		double dblSecond = 0;
		double result = FactoryOperation.makeOperation(CalcType.MULTIPLY, dblFirst, dblSecond);

		assertThat(result, is(0.0));
	}

	@Test
	void testAdd() throws Exception  {
		double dblFirst = 3;
		double dblSecond = 3;
		double result = FactoryOperation.makeOperation(CalcType.ADD, dblFirst, dblSecond);

		assertEquals(6, result);
		assertThat(result, not(0));
	}

	@Test
	void testSubtract() throws Exception  {
		double dblFirst = 9;
		double dblSecond = 6;
		double result = FactoryOperation.makeOperation(CalcType.SUBTRACT, dblFirst, dblSecond);

		assertTrue(result > 0);
		assertEquals(3, result);
	}
}
