package com.example.repaso.service.impl;

import com.example.repaso.controller.exceptions.ResourceNotFoundException;
import com.example.repaso.dto.ProductoDTO;
import com.example.repaso.entity.Producto;
import com.example.repaso.mappers.ProductoMapper;
import com.example.repaso.repository.ProductoRepository;
import com.example.repaso.service.service.ProductoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public ProductoDTO create(ProductoDTO productoDTO) throws ServiceException {
        try {
            return productoMapper.toDTO(productoRepository.save( productoMapper.toEntity(productoDTO)));
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el producto: "+e);
        }
    }

    @Override
    public ProductoDTO update(Long aLong, ProductoDTO productoDTO) throws ServiceException {
        try {
            Producto producto1 = productoRepository.findById(aLong).orElseThrow(() -> new ServiceException("No existe el producto"));
            producto1.setNombre(productoDTO.getNombre());
            producto1.setPrecio(productoDTO.getPrecio());
            return productoMapper.toDTO(productoRepository.save(producto1));
        } catch (ResourceNotFoundException e) {
            throw (e);
        } catch (Exception e) {
            throw new ServiceException("Error al actualizar el producto: "+e);
        }
    }

    @Override
    public ProductoDTO findById(Long aLong) throws ServiceException {
        try {
            Producto prod =  productoRepository.findById(aLong).orElseThrow(() -> new ServiceException("No existe el producto"));
            return productoMapper.toDTO(prod);
        }catch (ResourceNotFoundException e) {
            throw (e);
        } catch (Exception e) {
            throw new ServiceException("Error al leer el producto con id " + aLong, e);
        }
    }

    @Override
    public void deleteById(Long aLong) throws ServiceException {
        try {
            if(!productoRepository.findById(aLong).isPresent()){
                throw new ServiceException("No existe el producto");
            }
            productoRepository.deleteById(aLong);
        }catch (ResourceNotFoundException e) {
            throw (e);
        } catch (Exception e) {
            throw new ServiceException("Error al eliminar el producto con id " + aLong, e);
        }
    }

    @Override
    public List<ProductoDTO> findAll() throws ServiceException {
        try {
            return productoMapper.toDTOs(productoRepository.findAll());
        }catch (ResourceNotFoundException e) {
            throw (e);
        } catch (Exception e) {
            throw new ServiceException("Error al listar los productos " + e);
        }
    }
}
