package com.example.tdd.controller;

import com.example.tdd.model.BookingModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @GetMapping
    @ResponseBody
    public String getAll(){
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<BookingModel> save(@RequestBody BookingModel bookingModel){
        System.out.println(bookingModel.toString());
        return ResponseEntity.status(200).body(bookingModel);
    }
}
