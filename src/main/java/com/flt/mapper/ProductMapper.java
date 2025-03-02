package com.flt.mapper;

import com.flt.dto.ProductDTO;
import com.flt.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDTO dto);
    ProductDTO toDto(Product entity);
}

