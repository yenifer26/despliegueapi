package com.jdc.finalelectiva.service.ServiceImplement;

import com.jdc.finalelectiva.dto.DetalleVentaDTO;
import com.jdc.finalelectiva.entity.DetalleVentaEntity;
import com.jdc.finalelectiva.entity.ProductosEntity;
import com.jdc.finalelectiva.entity.VentasEntity;
import com.jdc.finalelectiva.repositories.DetalleVentaRepository;
import com.jdc.finalelectiva.repositories.ProductosRepository;
import com.jdc.finalelectiva.repositories.VentasRepository;
import com.jdc.finalelectiva.service.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleVentaServiceImplement implements IDetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<DetalleVentaEntity> findAll() {
        return detalleVentaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleVentaEntity findById(Integer id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public DetalleVentaEntity save(DetalleVentaDTO objDetalleVentaDTO) {
        VentasEntity ventafk = ventasRepository.findById(objDetalleVentaDTO.getFkventa()).orElse(null);
        ProductosEntity prodfk = productosRepository.findById(objDetalleVentaDTO.getFkproducto()).orElse(null);

        DetalleVentaEntity detalleVenta = new DetalleVentaEntity();
        detalleVenta.setFkventa(ventafk);
        detalleVenta.setFkproducto(prodfk);
        detalleVenta.setCantidad(objDetalleVentaDTO.getCantidad());
        detalleVenta.setSubtotal(objDetalleVentaDTO.getSubtotal());

        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        detalleVentaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public DetalleVentaEntity update(Integer id, DetalleVentaDTO objDetalleVentaDTO) {
        DetalleVentaEntity detalleExsi = detalleVentaRepository.findById(id).orElse(null);

        VentasEntity ventafk = ventasRepository.findById(objDetalleVentaDTO.getFkventa()).orElseThrow(
                () -> new RuntimeException("La venta con id " + objDetalleVentaDTO.getFkventa()+ " no existe"));
        ProductosEntity prodfk = productosRepository.findById(objDetalleVentaDTO.getFkproducto()).orElseThrow(
                () -> new RuntimeException("El producto con id " + objDetalleVentaDTO.getFkproducto()+ " no existe"));
        detalleExsi.setFkventa(ventafk);
        detalleExsi.setFkproducto(prodfk);
        detalleExsi.setCantidad(objDetalleVentaDTO.getCantidad());
        detalleExsi.setSubtotal(objDetalleVentaDTO.getSubtotal());

        return detalleVentaRepository.save(detalleExsi);
    }
}
