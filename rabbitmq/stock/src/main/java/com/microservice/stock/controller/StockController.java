package com.microservice.stock.controller;

import com.microservice.stock.service.RabbitMQService;
import constants.RabbitMQConstants;
import dto.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "stock")
public class StockController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity updateStock(@RequestBody StockDto dto){
        this.rabbitMQService.sendMessage(RabbitMQConstants.STOCK_QUEUE, dto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
