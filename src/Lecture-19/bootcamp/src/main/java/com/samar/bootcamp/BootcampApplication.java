package com.samar.bootcamp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.samar.bootcamp.jackson.Product;
import com.samar.bootcamp.jackson.ProductMetaData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(BootcampApplication.class, args);
		System.out.println("Hello Samar !!!");

		// objects creation
		Product product = new Product();
		product.setId(105);
		product.setName("i-pad");
		product.setManufacturerName("Apple Inc.");
		ProductMetaData pmd = new ProductMetaData();
		pmd.setMajorVersion("11");
		pmd.setMinorVersion("2.9");
		product.setProductMetaData(pmd);

		ObjectMapper objectMapper = new ObjectMapper();

		// By default, Jackson will only work with fields that are either public, or
		// have a public getter methods – serializing an entity that has all fields
		// private or package private will fail. And Jackson throws error on facing
		// this issue which we can pacify by doing 👇
		// but still jackson won't be able to do serialization and an empty object
		// will be returned
//		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		// serialization
		System.out.println(objectMapper.writeValueAsString(product));

		// deserialize
		String json = "{\"id\":107,\"name\":\"Alexa\",\"manufacturerName\":\"Amazon Inc.\",\"productMetaData\":{\"majorVersion\":\"11\",\"minorVersion\":\"2.9\"}}";
		Product p1 = objectMapper.readValue(json, Product.class);
		System.out.println("p1: " + p1);

		func(objectMapper);
	}

	private static void func(ObjectMapper mapper) throws JsonProcessingException {
		String productsJson = "[" +
				"{\"id\":107,\"name\":\"Alexa\",\"manufacturerName\":\"Amazon Inc.\",\"productMetaData\":{\"majorVersion\":\"11\",\"minorVersion\":\"2.9\"}}," +
		"{\"id\":107,\"name\":\"HomePod\",\"manufacturerName\":\"Apple Inc.\",\"productMetaData\":{\"majorVersion\":\"11\",\"minorVersion\":\"2.9\"}}" +
				"]";

		// below code will give you error, because jackson converted json into
		// List<LinkedHashMap> and we are assuming it to be List<Product>
//		List<Product> list = mapper.readValue(productsJson, List.class);
//		System.out.println("list: " + list);
//		for (Product p : list) System.out.println("prod: " + p);

		// so, when you are not sure of Object into which conversion needs to
		// take place, then we can use TypeReference, it can internally identify
		// the correct Conversion Class, hence above code will work now
		List<Product> list = mapper.readValue(productsJson, new TypeReference<>() {});
		System.out.println("list: " + list);
		for (Product p : list) System.out.println("prod: " + p);
		// so whenever dealing with a Map or List (or simply a collection object),
		// if not sure, use TypeReference
	}

}
