package com.microservice.stock.controller;

import com.microservice.stock.service.RabbitMQService;
import constants.RabbitMQConstants;
import dto.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "price")
public class PriceController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity updatePrice(@RequestBody PriceDto dto){
        this.rabbitMQService.sendMessage(RabbitMQConstants.PRICE_QUEUE, dto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
