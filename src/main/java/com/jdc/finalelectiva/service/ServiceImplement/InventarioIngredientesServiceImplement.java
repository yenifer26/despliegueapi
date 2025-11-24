package com.jdc.finalelectiva.service.ServiceImplement;

import com.jdc.finalelectiva.dto.InventarioIngredientesDTO;
import com.jdc.finalelectiva.entity.IngredientesEntity;
import com.jdc.finalelectiva.entity.InventarioIngredientesEntity;
import com.jdc.finalelectiva.repositories.IngredientesRepository;
import com.jdc.finalelectiva.repositories.InventarioIngredientesRepository;
import com.jdc.finalelectiva.service.IInventarioIngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventarioIngredientesServiceImplement implements IInventarioIngredientesService {

    @Autowired
    private InventarioIngredientesRepository inventarioIngredientesRepository;

    @Autowired
    private IngredientesRepository ingredientesRepository;

    @Override
    public List<InventarioIngredientesEntity> findAll() {
        return inventarioIngredientesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public InventarioIngredientesEntity findById(Integer id) {
        return inventarioIngredientesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public InventarioIngredientesEntity save(InventarioIngredientesDTO objInventarioIngredientesDTO) {
        IngredientesEntity ingre = ingredientesRepository.findById(objInventarioIngredientesDTO.getFkingrediente()).orElse(null);

        InventarioIngredientesEntity ingredientesinv = new InventarioIngredientesEntity();

        ingredientesinv.setFkingrediente(ingre);
        ingredientesinv.setCantidad(objInventarioIngredientesDTO.getCantidad());

        return inventarioIngredientesRepository.save(ingredientesinv);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ingredientesRepository.deleteById(id);
    }

    @Override
    @Transactional
    public InventarioIngredientesEntity update(Integer id, InventarioIngredientesDTO objInventarioIngredientesDTO) {
        InventarioIngredientesEntity ingreExi = inventarioIngredientesRepository.findById(id).orElse(null);

        IngredientesEntity ingre = ingredientesRepository.findById(objInventarioIngredientesDTO.getFkingrediente()).orElseThrow(
                () -> new RuntimeException("La ingrediente con id " + objInventarioIngredientesDTO.getFkingrediente()+ " no existe"));

        ingreExi.setFkingrediente(ingre);
        ingreExi.setCantidad(objInventarioIngredientesDTO.getCantidad());

        return inventarioIngredientesRepository.save(ingreExi);
    }


}
