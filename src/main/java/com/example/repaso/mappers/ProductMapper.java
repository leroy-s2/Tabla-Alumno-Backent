package com.example.repaso.mappers;

import com.example.repaso.dto.ProductDTO;
import com.example.repaso.entity.Product;
import com.example.repaso.mappers.base.BaseMappers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMappers<Product, ProductDTO> {
}
