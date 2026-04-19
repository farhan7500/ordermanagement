package com.nomani.ordermanagement.service;

import com.nomani.ordermanagement.dao.ProductRepository;
import com.nomani.ordermanagement.dto.ProductDto;
import com.nomani.ordermanagement.entity.Product;
import com.nomani.ordermanagement.exceptions.BadRequestException;
import com.nomani.ordermanagement.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findAll() {
        log.info("Listing all products");
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : productRepository.findAll()) {
            productDtos.add(
                    new ProductDto(product.getId(),
                            product.getName(),
                            product.getDescription(),
                            product.getPrice(),
                            product.getStock())
            );
        }
        return productDtos;
    }

    @Override
    public ProductDto findById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return new ProductDto(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getStock()
            );
        }
        throw new ResourceNotFoundException("Product not found. ID: " + id);
    }

    @Override
    @Transactional
    public ProductDto save(Product product) {
        if(!this.validateIncomingProduct(product)) {
            throw new BadRequestException("Unable to validate the product");
        }

        Product createdProduct = productRepository.save(product);
        return new ProductDto(
                createdProduct.getId(),
                createdProduct.getName(),
                createdProduct.getDescription(),
                createdProduct.getPrice(),
                createdProduct.getStock()
        );
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    private boolean validateIncomingProduct(Product product) {
        if(product.getStock() == null || product.getStock() < 0) {
            return false;
        }

        if(product.getPrice() == null || product.getPrice() <= 0) {
            return false;
        }

        return true;
    }
}
