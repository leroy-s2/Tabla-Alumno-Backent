package com.example.repaso.service.impl;

import com.example.repaso.dto.AlumnoDTO;
import com.example.repaso.entity.Alumno;
import com.example.repaso.mappers.AlumnoMapper;
import com.example.repaso.repository.AlumnoRepository;
import com.example.repaso.service.service.AlumnoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }

    @Override
    public AlumnoDTO create(AlumnoDTO alumnoDTO) throws ServiceException {
        try {
            Alumno alumno = alumnoMapper.toEntity(alumnoDTO);
            Alumno alumnoSaved = alumnoRepository.save(alumno);
            return alumnoMapper.toDTO(alumnoSaved);
        } catch (Exception e) {
            throw new ServiceException("Error al crear alumno", e);
        }
    }

    @Override
    public AlumnoDTO update(Long id, AlumnoDTO alumnoDTO) throws ServiceException {
        try {
            Alumno alumno = alumnoRepository.findById(id)
                    .orElseThrow(() -> new ServiceException("Alumno no encontrado con id: " + id));

            // Actualizar campos
            alumno.setNombres(alumnoDTO.getNombres());
            alumno.setApellidos(alumnoDTO.getApellidos());
            alumno.setCorreo(alumnoDTO.getCorreo());

            Alumno alumnoUpdated = alumnoRepository.save(alumno);
            return alumnoMapper.toDTO(alumnoUpdated);
        } catch (Exception e) {
            throw new ServiceException("Error al actualizar alumno", e);
        }
    }

    @Override
    public AlumnoDTO findById(Long id) throws ServiceException {
        try {
            Alumno alumno = alumnoRepository.findById(id)
                    .orElseThrow(() -> new ServiceException("Alumno no encontrado con id: " + id));
            return alumnoMapper.toDTO(alumno);
        } catch (Exception e) {
            throw new ServiceException("Error al buscar alumno", e);
        }
    }

    @Override
    public void deleteById(Long id) throws ServiceException {
        try {
            if (!alumnoRepository.existsById(id)) {
                throw new ServiceException("Alumno no encontrado con id: " + id);
            }
            alumnoRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Error al eliminar alumno", e);
        }
    }

    @Override
    public List<AlumnoDTO> findAll() throws ServiceException {
        try {
            List<Alumno> alumnos = alumnoRepository.findAll();
            return alumnoMapper.toDTOs(alumnos);
        } catch (Exception e) {
            throw new ServiceException("Error al listar los alumnos", e);
        }
    }
}
