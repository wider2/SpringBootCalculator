package com.project.calculator.controller;

import java.time.Duration;
import java.time.Instant;

import com.project.calculator.model.CalcResult;
import com.project.calculator.base.CalcType;
import com.project.calculator.base.FactoryOperation;
import com.project.calculator.model.ResponseResult;
import com.project.calculator.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class CalcController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/api/add", method = RequestMethod.GET, produces = "application/json")
    public String getAdd(@RequestParam(required = true) String first, @RequestParam(required = true) String second) throws Exception {

        if (Utility.isNumericValue(first) && Utility.isNumericValue(second)) {
            Instant start = Instant.now();
            double dblFirst = Double.parseDouble(first);
            double dblSecond = Double.parseDouble(second);
            double result = FactoryOperation.makeOperation(CalcType.ADD, dblFirst, dblSecond);

            Instant finish = Instant.now();
            logger.info("getAdd: -> {}, time: {} ms", result, Duration.between(start, finish).toMillis());

            return Utility.convertToJson(new CalcResult(result, CalcType.ADD, dblFirst, dblSecond));
        } else {
            ResponseResult responseResult = new ResponseResult(false, "Input parameter is incorrect. Please fix it.");
            return Utility.convertToJson(responseResult);
        }
    }

    @GetMapping(value = "/api/subtract", produces = "application/json")
    @ResponseBody
    public String getSubtract(@RequestParam(required = true) String first, @RequestParam(required = true) String second) throws Exception {
        if (Utility.isNumericValue(first) && Utility.isNumericValue(second)) {
            Instant start = Instant.now();
            double dblFirst = Double.parseDouble(first);
            double dblSecond = Double.parseDouble(second);
            double result = FactoryOperation.makeOperation(CalcType.SUBTRACT, dblFirst, dblSecond);

            Instant finish = Instant.now();
            logger.info("getSubtract: -> {}, time: {} ms", result, Duration.between(start, finish).toMillis());

            return Utility.convertToJson(new CalcResult(result, CalcType.SUBTRACT, dblFirst, dblSecond));
        } else {
            ResponseResult responseResult = new ResponseResult(false, "Input parameter is incorrect. Please fix it.");
            return Utility.convertToJson(responseResult);
        }
    }

    @GetMapping(value = "/api/multiply", produces = "application/json")
    @ResponseBody
    public String getMultiply(@RequestParam(required = true) String first, @RequestParam(required = true) String second) throws Exception {
        if (Utility.isNumericValue(first) && Utility.isNumericValue(second)) {
            Instant start = Instant.now();
            double dblFirst = Double.parseDouble(first);
            double dblSecond = Double.parseDouble(second);
            double result = FactoryOperation.makeOperation(CalcType.MULTIPLY, dblFirst, dblSecond);

            Instant finish = Instant.now();
            logger.info("getMultiply: -> {}, time: {} ms.", result, Duration.between(start, finish).toMillis());

            return Utility.convertToJson(new CalcResult(result, CalcType.MULTIPLY, dblFirst, dblSecond));
        } else {
            ResponseResult responseResult = new ResponseResult(false, "Input parameter is incorrect. Please fix it.");
            return Utility.convertToJson(responseResult);
        }
    }
}
