package com.jdc.finalelectiva.service.ServiceImplement;

import com.jdc.finalelectiva.dto.UsuariosDTO;
import com.jdc.finalelectiva.entity.UsuariosEntity;
import com.jdc.finalelectiva.repositories.UsuariosRepository;
import com.jdc.finalelectiva.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosServiceImplement implements IUsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<UsuariosEntity> findAll() {
        return usuariosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UsuariosEntity findById(Integer id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public UsuariosEntity save(UsuariosDTO objUsuariosDTO) {
        UsuariosEntity user = new UsuariosEntity();

        user.setNombre(objUsuariosDTO.getNombre());
        user.setEmail(objUsuariosDTO.getEmail());
        user.setRol(objUsuariosDTO.getRol());
        user.setActivo(objUsuariosDTO.isActivo());
        user.setFechacreacion(objUsuariosDTO.getFechacreacion());

        return usuariosRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        usuariosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UsuariosEntity update(Integer id, UsuariosDTO objUsuariosDTO) {
        UsuariosEntity user = usuariosRepository.findById(id).orElse(null);

        user.setNombre(objUsuariosDTO.getNombre());
        user.setEmail(objUsuariosDTO.getEmail());
        user.setRol(objUsuariosDTO.getRol());
        user.setActivo(objUsuariosDTO.isActivo());
        user.setFechacreacion(objUsuariosDTO.getFechacreacion());

        return usuariosRepository.save(user);

    }
}
