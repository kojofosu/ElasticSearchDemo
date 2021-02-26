package com.mcdev.ElasticSearchDemo.services;

import com.mcdev.ElasticSearchDemo.models.Product;
import com.mcdev.ElasticSearchDemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSearchWithRepository {
    @Autowired
    private ProductRepository productRepository;

    public Product createProductIndex(Product product) {
        return productRepository.save(product);
    }

    public List<Product> createProductIndexBulk(List<Product> productList) {
        List<Product> products = new ArrayList<>();
        Iterable<Product> productIterable =  productRepository.saveAll(productList);
        for (Product product : productIterable) {
            products.add(product);
        }
        return products;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        Iterable<Product> productIterable = productRepository.findAll();
        for (Product product : productIterable) {
            productList.add(product);
        }
        return productList;
    }

    public List<Product> getProductsByExactName(String productName) {
        List<Product> productList = new ArrayList<>();
        Iterable<Product> productIterable = productRepository.findByName(productName);
        for (Product product : productIterable) {
            productList.add(product);
        }
        return productList;
    }

    public List<Product> getProductByTermInName(String searchTerm) {
        List<Product> productList = new ArrayList<>();
        Iterable<Product> productIterable = productRepository.findByNameContaining(searchTerm);
        for (Product product : productIterable) {
            productList.add(product);
        }
        return productList;
    }
}
