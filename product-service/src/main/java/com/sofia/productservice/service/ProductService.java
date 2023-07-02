package com.sofia.productservice.service;

/*
*
* Lombok - annotation-based java library that allows you to reduce boilerplate code
* ex. @RequiredArgsConstructor - it will fix automatically required constructor for injected Class
* @Sl4j - use for logs
*   ex: log.info("{}", <value>)
*
* */



import com.sofia.productservice.dto.ProductRequestTo;
import com.sofia.productservice.model.Product;
import com.sofia.productservice.repository.ProductRepository;
import com.sofia.productservice.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;


    //builder is to input the data from client to Product Model
    public void createProduct(ProductRequestTo productRequestTo){
        Product product = Product.builder()
                .name(productRequestTo.getName())
                .description(productRequestTo.getDescription())
                .price(productRequestTo.getPrice())
                .build();
        //save() - method in CRUD.class library
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }


    //customize method to fillin the data to ResponseDto
    private ProductResponse mapToProductResponse(Product product) {
            return ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .build();
    }
}
