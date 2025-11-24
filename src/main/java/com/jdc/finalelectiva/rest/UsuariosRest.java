package com.jdc.finalelectiva.rest;

import com.jdc.finalelectiva.dto.UsuariosDTO;
import com.jdc.finalelectiva.entity.UsuariosEntity;
import com.jdc.finalelectiva.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuariosRest {

    @Autowired
    private IUsuariosService usuariosService;

    @GetMapping("listar")
    public ResponseEntity<List<UsuariosEntity>> findAll() {
        return ResponseEntity.ok(usuariosService.findAll());
    }

    @GetMapping("listarby/{id}")
    public ResponseEntity<UsuariosEntity> findbyid(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(usuariosService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuariosEntity> crear(
            @RequestBody @Validated UsuariosDTO objRegistrar){
        try{
            UsuariosEntity obj = usuariosService.save(objRegistrar);
            ResponseEntity.status(200);
            return ResponseEntity.ok(obj);
        }catch(Exception e){
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        try{
            usuariosService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Registro eliminado: "+ id);
        }catch(Exception e){
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UsuariosEntity> actualizar(
            @PathVariable("id") Integer id,
            @RequestBody @Validated UsuariosDTO user) {
        try {
            UsuariosEntity actualizado = usuariosService.update(id, user);
            ResponseEntity.status(200);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
