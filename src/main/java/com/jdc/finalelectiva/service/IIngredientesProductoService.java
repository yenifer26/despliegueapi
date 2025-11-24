package com.jdc.finalelectiva.service;

import com.jdc.finalelectiva.dto.IngredientesProductoDTO;
import com.jdc.finalelectiva.entity.IngredientesProductoEntity;

import java.util.List;

public interface IIngredientesProductoService {
    public List<IngredientesProductoEntity> findAll();
    public IngredientesProductoEntity findById(Integer id);

    public IngredientesProductoEntity save(IngredientesProductoDTO objIngredientesProductoDTO);
    public void delete(Integer id);
    public IngredientesProductoEntity update(Integer id, IngredientesProductoDTO objIngredientesProductoDTO);
}
