package com.example.repaso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private CategoriaDTO categoria;
}
