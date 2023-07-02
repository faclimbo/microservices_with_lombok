package com.sofia.productservice.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
/* Lombok - annotation-based java library that allows you to reduce boilerplate code
* ex. @RequiredArgsConstructor - it will fix automatically required constructor for injected Class
*@AllArgsConstructor
* @Builder
* @Data - for data
* @Document - mongodb annotation
*  @Sl4j - use for logs
*   ex: log.info("{}", <value>)
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    private String Id;
    private String name;
    private String description;
    private BigDecimal price;
}
