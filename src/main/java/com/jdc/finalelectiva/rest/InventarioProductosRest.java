package com.jdc.finalelectiva.rest;


import com.jdc.finalelectiva.dto.InventarioProductosDTO;
import com.jdc.finalelectiva.entity.InventarioProductosEntity;
import com.jdc.finalelectiva.service.IInventarioProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarioProducto")
public class InventarioProductosRest {

    @Autowired
    private IInventarioProductosService inventarioProductosService;

    @GetMapping("listar")
    public ResponseEntity<List<InventarioProductosEntity>> findAll() {
        return ResponseEntity.ok(inventarioProductosService.findAll());
    }

    @GetMapping("listarby/{id}")
    public ResponseEntity<InventarioProductosEntity> findbyid(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(inventarioProductosService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<InventarioProductosEntity> crear(
            @RequestBody @Validated InventarioProductosDTO objRegistrar){
        try{
            InventarioProductosEntity obj = inventarioProductosService.save(objRegistrar);
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
            inventarioProductosService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Registro eliminado: "+ id);
        }catch(Exception e){
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InventarioProductosEntity> actualizar(
            @PathVariable("id") Integer id,
            @RequestBody @Validated InventarioProductosDTO ingre) {
        try {
            InventarioProductosEntity actualizado = inventarioProductosService.update(id, ingre);
            ResponseEntity.status(200);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
