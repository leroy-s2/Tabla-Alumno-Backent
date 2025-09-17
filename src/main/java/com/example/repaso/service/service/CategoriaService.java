package com.example.repaso.service.service;

import com.example.repaso.dto.CategoriaDTO;
import com.example.repaso.entity.Categoria;
import com.example.repaso.service.base.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaService extends GenericService<Categoria, CategoriaDTO, Long> {

}
