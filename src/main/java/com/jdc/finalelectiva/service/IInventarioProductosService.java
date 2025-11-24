package com.jdc.finalelectiva.service;

import com.jdc.finalelectiva.dto.InventarioProductosDTO;
import com.jdc.finalelectiva.entity.InventarioProductosEntity;

import java.util.List;

public interface IInventarioProductosService {
    public List<InventarioProductosEntity> findAll();
    public InventarioProductosEntity findById(Integer id);

    public InventarioProductosEntity save(InventarioProductosDTO objInventarioProductosDTO);
    public void delete(Integer id);
    public InventarioProductosEntity update(Integer id, InventarioProductosDTO objInventarioProductosDTO);
}
