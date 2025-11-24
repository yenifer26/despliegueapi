package com.jdc.finalelectiva.service;

import com.jdc.finalelectiva.dto.DetalleVentaDTO;
import com.jdc.finalelectiva.entity.DetalleVentaEntity;

import java.util.List;

public interface IDetalleVentaService {
    public List<DetalleVentaEntity> findAll();
    public DetalleVentaEntity findById(Integer id);

    public DetalleVentaEntity save(DetalleVentaDTO objDetalleVentaDTO);
    public void delete(Integer id);
    public DetalleVentaEntity update(Integer id, DetalleVentaDTO objDetalleVentaDTO);
}
