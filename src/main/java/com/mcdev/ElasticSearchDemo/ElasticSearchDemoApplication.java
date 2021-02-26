package com.mcdev.ElasticSearchDemo;

import com.google.gson.Gson;
import com.mcdev.ElasticSearchDemo.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticSearchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchDemoApplication.class, args);
		Product sampleProduct = new Product();
		sampleProduct.setId("1");
		sampleProduct.setName("name");
		sampleProduct.setDescription("desc");
		sampleProduct.setManufacturer("manufacturer");
		sampleProduct.setQuantity(1);
		sampleProduct.setPrice(12.12);

		Gson gson = new Gson();
		System.out.println("Sample json : " + gson.toJson(sampleProduct));
	}

}
