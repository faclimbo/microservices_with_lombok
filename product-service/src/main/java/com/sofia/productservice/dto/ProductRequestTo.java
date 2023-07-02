package com.sofia.productservice.dto;
/*
*
* DTO - data access object
* put getter and setters
*
* */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestTo {
    private String name;
    private String description;
    private BigDecimal price;

}
