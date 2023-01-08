package com.nighthawk.spring_portfolio.mvc.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Calculator api, endpoint: /api/calculator/
@RestController
@RequestMapping("/api/calculator")
public class CalculatorApiController {
    @GetMapping("/start")
    public ResponseEntity<String> Calculator(@RequestBody String expression) {
        try {
            Calculator calculation = new Calculator(expression);
            return new ResponseEntity<>(calculation.toString(), HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}