package com.example.repaso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Integer price;
}
