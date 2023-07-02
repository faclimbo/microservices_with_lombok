package com.sofia.orderservice.controller;

import com.sofia.orderservice.dto.OrderRequestDto;
import com.sofia.orderservice.service.OrderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServices orderServices;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
        orderServices.placeOrder(orderRequestDto);
        return "Order Placed Successfully";
    }
}
