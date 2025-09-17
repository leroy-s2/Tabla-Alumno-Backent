package com.example.repaso.controller.general;

import com.example.repaso.dto.CategoriaDTO;
import com.example.repaso.entity.Categoria;
import com.example.repaso.repository.CategoriaRepository;
import com.example.repaso.service.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {

        this.categoriaService = categoriaService;
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listAll() throws ServiceException {

        return ResponseEntity.ok(categoriaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> read(@PathVariable Long id) throws ServiceException {
        CategoriaDTO categoriaDTO = categoriaService.findById(id);
        return ResponseEntity.ok(categoriaDTO);
    }
    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoriaDTO) throws ServiceException {
        CategoriaDTO categoriaDTO1 = categoriaService.create(categoriaDTO);
        return new ResponseEntity<>(categoriaDTO1,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) throws ServiceException {
        CategoriaDTO categoriaDTO1 = categoriaService.update(id,categoriaDTO);
        return ResponseEntity.ok(categoriaDTO1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ServiceException {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
