package com.mcdev.ElasticSearchDemo.controllers;

import com.mcdev.ElasticSearchDemo.services.ProductSearchWithRepository;
import com.mcdev.ElasticSearchDemo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductSearchWithRepository productSearchWithRepository;

    @PostMapping
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
        return productSearchWithRepository.createProductIndex(product);
    }

    @GetMapping
    @ResponseBody
    public List<Product> getAllProducts() {
        return productSearchWithRepository.getAllProducts();
    }

    @GetMapping("/name/{name}")
    @ResponseBody
    public List<Product> getProductByName(@PathVariable String name) {
        return productSearchWithRepository.getProductsByExactName(name);
    }

    @GetMapping("/search/{term}")
    @ResponseBody
    public List<Product> getProductInName(@PathVariable String term) {
        return productSearchWithRepository.getProductByTermInName(term);
    }

}
