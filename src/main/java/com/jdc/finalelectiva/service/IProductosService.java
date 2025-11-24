package com.jdc.finalelectiva.service;

import com.jdc.finalelectiva.dto.ProductosDTO;
import com.jdc.finalelectiva.entity.ProductosEntity;

import java.util.List;

public interface IProductosService {
    public List<ProductosEntity> findAll();
    public ProductosEntity findById(Integer id);

    public ProductosEntity save(ProductosDTO objProductosDTO);
    public void delete(Integer id);
    public ProductosEntity update(Integer id, ProductosDTO objProductosDTO);
}
