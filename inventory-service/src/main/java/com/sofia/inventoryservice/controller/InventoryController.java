package com.sofia.inventoryservice.controller;

import com.sofia.inventoryservice.dto.InventoryResponseDto;
import com.sofia.inventoryservice.repository.InventoryRepository;
import com.sofia.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    private boolean isInStock(@PathVariable("sku-code") String skuCode){
        return inventoryService.isInStock(skuCode);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<InventoryResponseDto> isInStocks(@RequestParam List<String> skuCode) {
        return inventoryService.isInStock1(skuCode);
    }


}
