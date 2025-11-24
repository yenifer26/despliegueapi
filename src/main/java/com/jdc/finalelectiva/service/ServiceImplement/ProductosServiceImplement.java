package com.jdc.finalelectiva.service.ServiceImplement;

import com.jdc.finalelectiva.dto.IngredientesDTO;
import com.jdc.finalelectiva.dto.ProductosDTO;
import com.jdc.finalelectiva.entity.IngredientesEntity;
import com.jdc.finalelectiva.entity.ProductosEntity;
import com.jdc.finalelectiva.repositories.ProductosRepository;
import com.jdc.finalelectiva.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductosServiceImplement implements IProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<ProductosEntity> findAll() {
        return productosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductosEntity findById(Integer id) {
        return productosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ProductosEntity save(ProductosDTO objProductosDTO) {
        ProductosEntity prod = new ProductosEntity();

        prod.setNombre(objProductosDTO.getNombre());
        prod.setCategoria(objProductosDTO.getCategoria());
        prod.setPrecio(objProductosDTO.getPrecio());
        prod.setUnidad(objProductosDTO.getUnidad());
        prod.setActivo(objProductosDTO.isActivo());

        return productosRepository.save(prod);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        productosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ProductosEntity update(Integer id, ProductosDTO objProductosDTO) {
        ProductosEntity prod = productosRepository.findById(id).orElse(null);

        prod.setNombre(objProductosDTO.getNombre());
        prod.setCategoria(objProductosDTO.getCategoria());
        prod.setPrecio(objProductosDTO.getPrecio());
        prod.setUnidad(objProductosDTO.getUnidad());
        prod.setActivo(objProductosDTO.isActivo());

        return productosRepository.save(prod);

    }
}
