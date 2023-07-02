package com.sofia.productservice;

import com.sofia.productservice.dto.ProductRequestTo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	//ObjectMapper - it will convert from POJO to JSON. JSON to POJO
//	@Autowired
//	ObjectMapper objectMapper;
//
//	//Create this codes to setup the connection in testing================================================
//		@Container
//		static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0.7");
//		//initialize mongodb uri property from application url
//		@DynamicPropertySource
//		static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
//			dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//		}
//	//END==================================================================================================
//
//	@Test
//	void shouldCreateProduct() throws Exception{
//			ProductRequestTo productRequestTo = getProductRequest();
//			String producRequestString = objectMapper.writeValueAsString(productRequestTo);
//			mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
//					.contentType(MediaType.APPLICATION_JSON)
//					.content(producRequestString)).andExpect(status().isCreated());
//	}
//
//	private ProductRequestTo getProductRequest() {
//			return ProductRequestTo.builder()
//					.name("iPhone 13")
//					.description("iphone 13")
//					.price(BigDecimal.valueOf(1200))
//					.build();
//	}

}
