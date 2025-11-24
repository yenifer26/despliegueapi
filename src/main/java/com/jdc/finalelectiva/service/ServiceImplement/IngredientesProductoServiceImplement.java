package com.jdc.finalelectiva.service.ServiceImplement;

import com.jdc.finalelectiva.dto.IngredientesProductoDTO;
import com.jdc.finalelectiva.entity.*;
import com.jdc.finalelectiva.repositories.IngredientesProductoRepository;
import com.jdc.finalelectiva.repositories.IngredientesRepository;
import com.jdc.finalelectiva.repositories.ProductosRepository;
import com.jdc.finalelectiva.service.IIngredientesProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientesProductoServiceImplement implements IIngredientesProductoService {
    @Autowired
    private IngredientesProductoRepository ingredientesProductoRepository;

    @Autowired
    private IngredientesRepository ingredientesRepository;

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<IngredientesProductoEntity> findAll() {
        return ingredientesProductoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public IngredientesProductoEntity findById(Integer id) {
        return ingredientesProductoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public IngredientesProductoEntity save(IngredientesProductoDTO objIngredientesProductoDTO) {
        ProductosEntity prodfk = productosRepository.getReferenceById(objIngredientesProductoDTO.getFkproducto());
        IngredientesEntity ingre = ingredientesRepository.getReferenceById(objIngredientesProductoDTO.getFkingredient());

        IngredientesProductoEntity ingredientesProducto = new IngredientesProductoEntity();

        ingredientesProducto.setFkproducto(prodfk);
        ingredientesProducto.setFkingrediente(ingre);
        ingredientesProducto.setCantidad(objIngredientesProductoDTO.getCantidad());

        return ingredientesProductoRepository.save(ingredientesProducto);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ingredientesProductoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public IngredientesProductoEntity update(Integer id, IngredientesProductoDTO objIngredientesProductoDTO) {
        IngredientesProductoEntity ingreExi = ingredientesProductoRepository.findById(id).orElse(null);

        ProductosEntity prodfk = productosRepository.findById(objIngredientesProductoDTO.getFkproducto()).orElseThrow(
                () -> new RuntimeException("El producto con id " + objIngredientesProductoDTO.getFkproducto()+ " no existe"));
        IngredientesEntity ingre = ingredientesRepository.findById(objIngredientesProductoDTO.getFkingredient()).orElseThrow(
                () -> new RuntimeException("La ingrediente con id " + objIngredientesProductoDTO.getFkingredient()+ " no existe"));

        ingreExi.setFkproducto(prodfk);
        ingreExi.setFkingrediente(ingre);
        ingreExi.setCantidad(objIngredientesProductoDTO.getCantidad());

        return ingredientesProductoRepository.save(ingreExi);
    }
}
