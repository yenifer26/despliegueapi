package com.jdc.finalelectiva.service;

import com.jdc.finalelectiva.dto.InventarioIngredientesDTO;
import com.jdc.finalelectiva.entity.InventarioIngredientesEntity;

import java.util.List;

public interface IInventarioIngredientesService {
    public List<InventarioIngredientesEntity> findAll();
    public InventarioIngredientesEntity findById(Integer id);

    public InventarioIngredientesEntity save(InventarioIngredientesDTO objInventarioIngredientesDTO);
    public void delete(Integer id);
    public InventarioIngredientesEntity update(Integer id, InventarioIngredientesDTO objInventarioIngredientesDTO);
}
