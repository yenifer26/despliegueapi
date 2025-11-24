package com.jdc.finalelectiva.service;

import com.jdc.finalelectiva.dto.VentasDTO;
import com.jdc.finalelectiva.entity.VentasEntity;

import java.util.List;

public interface IVentasService {
    public List<VentasEntity> findAll();
    public VentasEntity findById(Integer id);

    public VentasEntity save(VentasDTO objVentasDTO);
    public void delete(Integer id);
    public VentasEntity update(Integer id, VentasDTO objVentasDTO);
}
