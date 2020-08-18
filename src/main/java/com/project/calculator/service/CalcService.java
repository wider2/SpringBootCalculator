package com.project.calculator.service;

import com.project.calculator.base.CalcType;
import com.project.calculator.base.FactoryOperation;
import com.project.calculator.model.CalcResult;
import com.project.calculator.model.ResponseResult;
import com.project.calculator.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class CalcService implements ICalcService {

   private Logger logger = LoggerFactory.getLogger(this.getClass());

   @Override
   public String createServiceOperation(CalcType calcType, String first, String second) throws Exception {

      if (Utility.isNumericValue(first) && Utility.isNumericValue(second)) {
         Instant start = Instant.now();
         double dblFirst = Double.parseDouble(first);
         double dblSecond = Double.parseDouble(second);
         double result = FactoryOperation.makeOperation(calcType, dblFirst, dblSecond);

         Instant finish = Instant.now();
         logger.info("Result: -> {}, takes time: {} ms", result, Duration.between(start, finish).toMillis());

         return Utility.convertToJson(new CalcResult(result, calcType, dblFirst, dblSecond));
      } else {
         ResponseResult responseResult = new ResponseResult(false, "Input parameter is incorrect. Please fix it.");
         return Utility.convertToJson(responseResult);
      }
   }
}
