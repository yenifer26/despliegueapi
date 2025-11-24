package com.jdc.finalelectiva.service.ServiceImplement;

import com.jdc.finalelectiva.dto.IngredientesDTO;
import com.jdc.finalelectiva.entity.IngredientesEntity;
import com.jdc.finalelectiva.repositories.IngredientesRepository;
import com.jdc.finalelectiva.service.IIngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientesServiceImplement implements IIngredientesService {

    @Autowired
    private IngredientesRepository ingredientesRepository;

    @Override
    public List<IngredientesEntity> findAll() {
        return ingredientesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public IngredientesEntity findById(Integer id) {
        return ingredientesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public IngredientesEntity save(IngredientesDTO objIngredientesDTO) {
        IngredientesEntity ingredientesEntity = new IngredientesEntity();

        ingredientesEntity.setNombre(objIngredientesDTO.getNombre());
        ingredientesEntity.setUnidad(objIngredientesDTO.getUnidad());
        ingredientesEntity.setPerecedero(objIngredientesDTO.isPerecedero());
        ingredientesEntity.setMinimo(objIngredientesDTO.getMinimo());

        return ingredientesRepository.save(ingredientesEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ingredientesRepository.deleteById(id);
    }

    @Override
    @Transactional
    public IngredientesEntity update(Integer id, IngredientesDTO objIngredientesDTO) {
        IngredientesEntity ingredientesEntity = ingredientesRepository.findById(id).orElse(null);

        ingredientesEntity.setNombre(objIngredientesDTO.getNombre());
        ingredientesEntity.setUnidad(objIngredientesDTO.getUnidad());
        ingredientesEntity.setPerecedero(objIngredientesDTO.isPerecedero());
        ingredientesEntity.setMinimo(objIngredientesDTO.getMinimo());

        return ingredientesRepository.save(ingredientesEntity);

    }
}
