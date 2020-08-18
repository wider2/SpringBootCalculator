package com.project.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.calculator.base.CalcType;
import com.project.calculator.controller.CalcController;
import com.project.calculator.model.CalcResult;
import com.project.calculator.model.ResponseResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MockController {

    private MockMvc mockMvc;
    private CalcResult modelSubtract;
    private CalcResult modelAdd;
    private CalcResult modelMultiply;
    private ResponseResult modelResponseResult;

    @InjectMocks
    private CalcController controller;

    private JacksonTester<CalcResult> jsonResult;
    private JacksonTester<ResponseResult> jsonResponseResult;

    @Before
    public void setup() {
        modelAdd = new CalcResult(4, CalcType.ADD,2,2);
        modelSubtract = new CalcResult(18, CalcType.SUBTRACT,9,-9);
        modelMultiply = new CalcResult(9, CalcType.MULTIPLY,3,3);
        modelResponseResult = new ResponseResult(false, "Input parameter is incorrect. Please fix it.");

        JacksonTester.initFields(this, new ObjectMapper());

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void TestShowControllerAdd() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/add?first=2&second=2")
                        .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertNotNull(response);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.getContentAsString()).isEqualTo(jsonResult.write(modelAdd).getJson() );
    }

    @Test
    public void TestShowControllerAddNegative() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/add?first=2bad")
                        .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void TestShowControllerAddWrongValue() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/add?first=2&second=2string")
                        .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertNotNull(response);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.getContentAsString()).isEqualTo(jsonResponseResult.write(modelResponseResult).getJson() );
    }

    @Test
    public void TestShowControllerSubtract() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/subtract?first=9&second=-9")
                        .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertNotNull(response);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.getContentAsString()).isEqualTo(jsonResult.write(modelSubtract).getJson() );
    }

    @Test
    public void TestShowControllerSubtractWrongValue() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/subtract")
                        .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertNotNull(response);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void TestShowControllerMultiply() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/multiply?first=3&second=3")
                        .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertNotNull(response);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.getContentAsString()).isEqualTo(jsonResult.write(modelMultiply).getJson() );
    }

}
