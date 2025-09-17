package com.example.repaso.controller.general;

import com.example.repaso.dto.ProductoDTO;
import com.example.repaso.repository.ProductoRepository;
import com.example.repaso.service.service.ProductoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
   private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> read(@PathVariable Long id) throws ServiceException {
        ProductoDTO ProductoDTO = productoService.findById(id);
        return ResponseEntity.ok(ProductoDTO);
    }
    @PostMapping
    public ResponseEntity<ProductoDTO> create(@RequestBody ProductoDTO ProductoDTO) throws ServiceException {
        ProductoDTO ProductoDTO1 = productoService.create(ProductoDTO);
        return new ResponseEntity<>(ProductoDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> update(@PathVariable Long id, @RequestBody ProductoDTO ProductoDTO) throws ServiceException {
        ProductoDTO ProductoDTO1 = productoService.update(id,ProductoDTO);
        return ResponseEntity.ok(ProductoDTO1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ServiceException {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
