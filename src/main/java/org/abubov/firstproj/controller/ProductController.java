package org.abubov.firstproj.controller;

import org.abubov.firstproj.entity.Product;
import org.abubov.firstproj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/products")
@RestController
public class ProductController {

    ProductService productService;


    public ResponseEntity<String> check(){
        String products = productService.getAllProducts().toString();
        return ResponseEntity.ok(products);
    }

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping
    Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }


}
