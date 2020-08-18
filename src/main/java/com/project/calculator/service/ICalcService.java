package com.project.calculator.service;

import com.project.calculator.base.CalcType;

public interface ICalcService {
   String createServiceOperation(CalcType calcType, String first, String second) throws Exception;
}
