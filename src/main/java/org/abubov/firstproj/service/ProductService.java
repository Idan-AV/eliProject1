package org.abubov.firstproj.service;

import org.abubov.firstproj.entity.Product;
import org.abubov.firstproj.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    productRepository productRepository;
    @Autowired
    public ProductService(productRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product productDetails){
        return productRepository.save(productDetails);
    }

    public String deleteProduct(Long id) {
        Product product = getProductById(id).get();
        productRepository.delete(product);
        return "Product deleted";
    }





}
