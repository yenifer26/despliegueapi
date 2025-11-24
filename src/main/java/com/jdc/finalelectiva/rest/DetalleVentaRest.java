package com.jdc.finalelectiva.rest;

import com.jdc.finalelectiva.dto.DetalleVentaDTO;
import com.jdc.finalelectiva.entity.DetalleVentaEntity;
import com.jdc.finalelectiva.service.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle")
public class DetalleVentaRest {

    @Autowired
    private IDetalleVentaService detalleVentaService;

    @GetMapping("listar")
    public ResponseEntity<List<DetalleVentaEntity>> findAll() {
        return ResponseEntity.ok(detalleVentaService.findAll());
    }

    @GetMapping("listarby/{id}")
    public ResponseEntity<DetalleVentaEntity> findbyid(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(detalleVentaService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<DetalleVentaEntity> crear(
            @RequestBody @Validated DetalleVentaDTO objRegistrar){
        try{
            DetalleVentaEntity obj = detalleVentaService.save(objRegistrar);
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
            detalleVentaService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Registro eliminado: "+ id);
        }catch(Exception e){
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DetalleVentaEntity> actualizar(
            @PathVariable("id") Integer id,
            @RequestBody @Validated DetalleVentaDTO detalle) {
        try {
            DetalleVentaEntity actualizado = detalleVentaService.update(id, detalle);
            ResponseEntity.status(200);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
