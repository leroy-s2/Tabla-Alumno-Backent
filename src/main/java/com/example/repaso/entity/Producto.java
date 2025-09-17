package com.example.repaso.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="TBL_PRODUCTOS")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOMBRE", unique = true, nullable = false, length = 50)
    private String nombre;
    @Column(name = "PRECIO", nullable = false)
    private BigDecimal precio;
    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID")
    private Categoria categoria;
}
