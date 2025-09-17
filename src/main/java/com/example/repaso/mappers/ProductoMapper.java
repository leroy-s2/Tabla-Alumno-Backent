package com.example.repaso.mappers;

import com.example.repaso.dto.ProductoDTO;
import com.example.repaso.entity.Producto;
import com.example.repaso.mappers.base.BaseMappers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper extends BaseMappers<Producto, ProductoDTO> {
}
