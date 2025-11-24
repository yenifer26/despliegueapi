package com.jdc.finalelectiva.service.ServiceImplement;

import com.jdc.finalelectiva.dto.VentasDTO;
import com.jdc.finalelectiva.entity.UsuariosEntity;
import com.jdc.finalelectiva.entity.VentasEntity;
import com.jdc.finalelectiva.repositories.UsuariosRepository;
import com.jdc.finalelectiva.repositories.VentasRepository;
import com.jdc.finalelectiva.service.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentasServiceImplement implements IVentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<VentasEntity> findAll() {
        return ventasRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public VentasEntity findById(Integer id) {
        return ventasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public VentasEntity save(VentasDTO objVentasDTO) {

        if (objVentasDTO.getFkusuario() == null) {
            throw new RuntimeException("fkusuario no puede ser null");
        }

        UsuariosEntity user = usuariosRepository.getReferenceById(objVentasDTO.getFkusuario());

        VentasEntity ventasEntity = new VentasEntity();

        ventasEntity.setFkusuario(user);
        ventasEntity.setFecha(objVentasDTO.getFecha());
        ventasEntity.setTotal(objVentasDTO.getTotal());

        return ventasRepository.save(ventasEntity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ventasRepository.deleteById(id);
    }

    @Override
    @Transactional
    public VentasEntity update(Integer id, VentasDTO objVentasDTO) {
        VentasEntity ventasEntity = ventasRepository.findById(id).orElse(null);

        UsuariosEntity user = usuariosRepository.findById(objVentasDTO.getFkusuario()).orElseThrow(
                () -> new RuntimeException("La venta con id " + objVentasDTO.getFkusuario()+ " no existe"));

        if (objVentasDTO.getFkusuario() == null) {
            throw new RuntimeException("fkusuario no puede ser null");
        }

        ventasEntity.setFkusuario(user);
        ventasEntity.setFecha(objVentasDTO.getFecha());
        ventasEntity.setTotal(objVentasDTO.getTotal());

        return ventasRepository.save(ventasEntity);
    }
}
