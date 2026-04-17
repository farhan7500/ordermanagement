package com.nomani.ordermanagement.service;

import com.nomani.ordermanagement.dto.ProductDto;
import com.nomani.ordermanagement.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(long id);
    ProductDto save(Product product);
    void deleteById(long id);
}
