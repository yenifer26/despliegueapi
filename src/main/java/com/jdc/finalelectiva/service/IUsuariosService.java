package com.jdc.finalelectiva.service;

import com.jdc.finalelectiva.dto.UsuariosDTO;
import com.jdc.finalelectiva.entity.UsuariosEntity;

import java.util.List;

public interface IUsuariosService {
    public List<UsuariosEntity> findAll();
    public UsuariosEntity findById(Integer id);

    public UsuariosEntity save(UsuariosDTO objUsuariosDTO);
    public void delete(Integer id);
    public UsuariosEntity update(Integer id, UsuariosDTO objUsuariosDTO);
}
