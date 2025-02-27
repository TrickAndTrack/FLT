package com.flt.service;


import com.flt.dto.ProductDTO;
import com.flt.mapper.ProductMapper;
import com.flt.model.Product;
import com.flt.repository.ProductRepository;
import com.flt.selector.ProductSelector;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;



    private final ProductSelector productSelector;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, ProductSelector productSelector) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productSelector = productSelector;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toDto);
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

