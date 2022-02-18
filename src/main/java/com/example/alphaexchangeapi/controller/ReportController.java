package com.example.alphaexchangeapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final Logger logger = LoggerFactory.getLogger(ReportController.class);

//    @GetMapping("/")
//    public ResponseEntity<?> reportDaily (){
//
//    }

    @GetMapping("/history")
    public ResponseEntity<?> reportHistory(@RequestParam String currency, @RequestParam String from,
                                           @RequestParam String to){
        logger.debug("in currency: {}, date_from: {}, date_to {}", currency, from, to);
        return null;
    }
}
