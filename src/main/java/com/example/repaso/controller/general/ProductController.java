package com.example.repaso.controller.general;

import com.example.repaso.dto.ProductDTO;
import com.example.repaso.dto.ProductoDTO;
import com.example.repaso.service.service.ProductService;
import com.example.repaso.service.service.ProductoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> read(@PathVariable Long id) throws ServiceException {
        ProductDTO productDTO = productService.findById(id);
        return ResponseEntity.ok(productDTO);
    }
    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO ProductDTO) throws ServiceException {
        ProductDTO productDTO1 = productService.create(ProductDTO);
        return new ResponseEntity<>(productDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) throws ServiceException {
        ProductDTO productDTO1 = productService.update(id,productDTO);
        return ResponseEntity.ok(productDTO1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ServiceException {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
