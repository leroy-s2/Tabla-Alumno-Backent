package com.example.repaso.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaDTO {
    private Long id;
    @NotEmpty(message = "El nombre de la categoría es obligatorio")
    @Size(max = 50, message = "El nombre de la categoría no debe superar los 50 caracteres")
    private String nombre;
}
