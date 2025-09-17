package com.example.repaso.mappers;

import com.example.repaso.dto.CategoriaDTO;
import com.example.repaso.entity.Categoria;
import com.example.repaso.mappers.base.BaseMappers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends BaseMappers<Categoria, CategoriaDTO> {
}
