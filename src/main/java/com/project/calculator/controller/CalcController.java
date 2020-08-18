package com.project.calculator.controller;

import com.project.calculator.base.CalcType;
import com.project.calculator.service.CalcService;
import org.springframework.web.bind.annotation.*;


@RestController
public class CalcController {
    CalcService calcService = new CalcService();


    @RequestMapping(value = "/api/add", method = RequestMethod.GET, produces = "application/json")
    public String getAdd(@RequestParam(required = true) String first, @RequestParam(required = true) String second) throws Exception {

        return calcService.createServiceOperation(CalcType.ADD, first, second);
    }

    @GetMapping(value = "/api/subtract", produces = "application/json")
    @ResponseBody
    public String getSubtract(@RequestParam(required = true) String first, @RequestParam(required = true) String second) throws Exception {

        return calcService.createServiceOperation(CalcType.SUBTRACT, first, second);
    }

    @GetMapping(value = "/api/multiply", produces = "application/json")
    @ResponseBody
    public String getMultiply(@RequestParam(required = true) String first, @RequestParam(required = true) String second) throws Exception {

        return calcService.createServiceOperation(CalcType.MULTIPLY, first, second);
    }
}
