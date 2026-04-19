package com.nomani.ordermanagement.rest;

import com.nomani.ordermanagement.dto.ProductDto;
import com.nomani.ordermanagement.entity.Product;
import com.nomani.ordermanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products")
    List<ProductDto> listProducts() {
        return productService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products/{id}")
    ProductDto getProductDetails(@PathVariable long id) {
        return productService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/products")
    ProductDto createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/products/{id}")
    ProductDto updateProduct(@PathVariable long id, @RequestBody Product product) {
        product.setId(id);
        return productService.save(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable long id) {
        productService.deleteById(id);
    }
}
