package com.jdc.finalelectiva.service;

import com.jdc.finalelectiva.dto.IngredientesDTO;
import com.jdc.finalelectiva.entity.IngredientesEntity;

import java.util.List;

public interface IIngredientesService {
    public List<IngredientesEntity> findAll();
    public IngredientesEntity findById(Integer id);

    public IngredientesEntity save(IngredientesDTO objIngredientesDTO);
    public void delete(Integer id);
    public IngredientesEntity update(Integer id, IngredientesDTO objIngredientesDTO);
}
