package com.project.calculator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.project.calculator.base.CalcType;
import com.project.calculator.model.CalcResult;
import com.project.calculator.model.ResponseResult;
import com.project.calculator.util.Utility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUtility {

	@Test
	public void testNumericRight() {
		assertTrue(Utility.isNumericValue("9000"));
		assertTrue(Utility.isNumericValue("8000.99"));
		assertTrue(Utility.isNumericValue("-789.99"));
		assertTrue(Utility.isNumericValue("000"));
	}

	@Test
	public void testNumericWrong() {
		assertFalse(Utility.isNumericValue("789,01"));
		assertFalse(Utility.isNumericValue("121 99"));
		assertFalse(Utility.isNumericValue(""));
		assertFalse(Utility.isNumericValue(null));
	}

	@Test
	public void testSerialize() throws JsonProcessingException {
		CalcResult calcResult = new CalcResult(9.0, CalcType.MULTIPLY, 3,3);

		String result = Utility.convertToJson(calcResult);
		assertNotNull(result);
	}

	@Test
	public void testJson() throws JsonProcessingException {
		ResponseResult responseResult = new ResponseResult(true, "result string");
		
		String result = Utility.convertToJson(responseResult);
		assertNotNull(result);
		assertThat(result, equalTo("{\"status\":true,\"message\":\"result string\"}"));
	}
		
}
