package com.example.repaso.controller.general;

import com.example.repaso.dto.AlumnoDTO;
import com.example.repaso.service.service.AlumnoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // GET /api/v1/alumnos
    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> findAll() throws ServiceException {
        return ResponseEntity.ok(alumnoService.findAll());
    }

    // GET /api/v1/alumnos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> read(@PathVariable Long id) throws ServiceException {
        AlumnoDTO alumnoDTO = alumnoService.findById(id);
        return ResponseEntity.ok(alumnoDTO);
    }

    // POST /api/v1/alumnos
    @PostMapping
    public ResponseEntity<AlumnoDTO> create(@RequestBody AlumnoDTO alumnoDTO) throws ServiceException {
        AlumnoDTO created = alumnoService.create(alumnoDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // PUT /api/v1/alumnos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> update(@PathVariable Long id, @RequestBody AlumnoDTO alumnoDTO) throws ServiceException {
        AlumnoDTO updated = alumnoService.update(id, alumnoDTO);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/v1/alumnos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ServiceException {
        alumnoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
