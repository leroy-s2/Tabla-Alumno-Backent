package com.example.repaso.service.impl;

import com.example.repaso.controller.exceptions.ResourceNotFoundException;
import com.example.repaso.dto.ProductDTO;
import com.example.repaso.entity.Product;
import com.example.repaso.entity.Producto;
import com.example.repaso.mappers.ProductMapper;
import com.example.repaso.repository.ProductRepository;
import com.example.repaso.service.service.ProductService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) throws ServiceException {
        try {
            return productMapper.toDTO(productRepository.save( productMapper.toEntity(productDTO)));
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el producto: "+e);
        }
    }

    @Override
    public ProductDTO update(Long aLong, ProductDTO productDTO) throws ServiceException {
        try {
            Product product1 = productRepository.findById(aLong).orElseThrow(() -> new ServiceException("No existe el producto"));
            product1.setName(productDTO.getName());
            product1.setPrice(productDTO.getPrice());
            return productMapper.toDTO(productRepository.save(product1));
        } catch (ResourceNotFoundException e) {
            throw (e);
        } catch (Exception e) {
            throw new ServiceException("Error al actualizar el producto: "+e);
        }
    }

    @Override
    public ProductDTO findById(Long aLong) throws ServiceException {
        try {
            Product prod =  productRepository.findById(aLong).orElseThrow(() -> new ServiceException("No existe el producto"));
            return productMapper.toDTO(prod);
        }catch (ResourceNotFoundException e) {
            throw (e);
        } catch (Exception e) {
            throw new ServiceException("Error al leer el product con id " + aLong, e);
        }
    }

    @Override
    public void deleteById(Long aLong) throws ServiceException {
        try {
            if(!productRepository.findById(aLong).isPresent()){
                throw new ServiceException("No existe el producto");
            }
            productRepository.deleteById(aLong);
        }catch (ResourceNotFoundException e) {
            throw (e);
        } catch (Exception e) {
            throw new ServiceException("Error al eliminar el producto con id " + aLong, e);
        }
    }

    @Override
    public List<ProductDTO> findAll() throws ServiceException {
        try {
            return productMapper.toDTOs(productRepository.findAll());
        }catch (ResourceNotFoundException e) {
            throw (e);
        } catch (Exception e) {
            throw new ServiceException("Error al listar los products " + e);
        }
    }
}
