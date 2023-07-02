package com.sofia.orderservice.service;

import com.sofia.orderservice.dto.InventoryResponseDto;
import com.sofia.orderservice.dto.OrderLineItemsDto;
import com.sofia.orderservice.dto.OrderRequestDto;
import com.sofia.orderservice.model.Order;
import com.sofia.orderservice.model.OrderLineItems;
import com.sofia.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServices {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    public void placeOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        
        List<OrderLineItems> orderLineItems = orderRequestDto.getOrderLineItemsDtos()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);


        //Collect all skuCOdes and put to List<String> from OrderLineItems Model
        List<String> skuCodes = order.getOrderLineItemsList().stream().
                map(OrderLineItems::getSkuCode).toList();

        //microservices -  Call inventory service and place order if product is in
        //stock
        //webClientBuilder = webflux library. tool to connect to other service
        //webClientBuilder bean is located in WebClientConfig
        //bodyToMono (class of the return item. ex: String, Boolean, or Object , etc...)
        InventoryResponseDto[] inventoryResponseDtoArray = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                        .bodyToMono(InventoryResponseDto[].class)
                                .block();

        boolean allProductIsInStock = Arrays.stream(inventoryResponseDtoArray).
                allMatch(InventoryResponseDto::isInStock);

        if(allProductIsInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product not in stock");
        }
        //======================================================================

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
