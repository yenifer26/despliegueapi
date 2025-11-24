package com.jdc.finalelectiva.service.ServiceImplement;

import com.jdc.finalelectiva.dto.InventarioIngredientesDTO;
import com.jdc.finalelectiva.dto.InventarioProductosDTO;
import com.jdc.finalelectiva.entity.IngredientesEntity;
import com.jdc.finalelectiva.entity.InventarioIngredientesEntity;
import com.jdc.finalelectiva.entity.InventarioProductosEntity;
import com.jdc.finalelectiva.entity.ProductosEntity;
import com.jdc.finalelectiva.repositories.IngredientesRepository;
import com.jdc.finalelectiva.repositories.InventarioIngredientesRepository;
import com.jdc.finalelectiva.repositories.InventarioProductosRepository;
import com.jdc.finalelectiva.repositories.ProductosRepository;
import com.jdc.finalelectiva.service.IInventarioProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventarioProductosServiceImplement implements IInventarioProductosService {
    @Autowired
    private InventarioProductosRepository inventarioProductosRepository;

    @Autowired
    private ProductosRepository productosRepository;


    @Override
    public List<InventarioProductosEntity> findAll() {
        return inventarioProductosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public InventarioProductosEntity findById(Integer id) {
        return inventarioProductosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public InventarioProductosEntity save(InventarioProductosDTO objInventarioProductosDTO) {
         ProductosEntity prodfk = productosRepository.findById(objInventarioProductosDTO.getFkproducto()).orElse(null);

        InventarioProductosEntity prodinv = new InventarioProductosEntity();

        prodinv.setFkproducto(prodfk);
        prodinv.setCantidad(objInventarioProductosDTO.getCantidad());

        return inventarioProductosRepository.save(prodinv);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        inventarioProductosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public InventarioProductosEntity update(Integer id, InventarioProductosDTO objInventarioProductosDTO) {
        InventarioProductosEntity invproExi = inventarioProductosRepository.findById(id).orElse(null);

        ProductosEntity prodfk = productosRepository.findById(objInventarioProductosDTO.getFkproducto()).orElseThrow(
                () -> new RuntimeException("El producto con id " + objInventarioProductosDTO.getFkproducto()+ " no existe"));

        invproExi.setFkproducto(prodfk);
        invproExi.setCantidad(objInventarioProductosDTO.getCantidad());

        return inventarioProductosRepository.save(invproExi);
    }
}
