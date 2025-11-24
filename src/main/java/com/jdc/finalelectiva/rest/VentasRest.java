package com.jdc.finalelectiva.rest;

import com.jdc.finalelectiva.dto.VentasDTO;
import com.jdc.finalelectiva.entity.VentasEntity;
import com.jdc.finalelectiva.service.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentasRest {

    @Autowired
    private IVentasService ventasService;

    @GetMapping("listar")
    public ResponseEntity<List<VentasEntity>> findAll() {
        return ResponseEntity.ok(ventasService.findAll());
    }

    @GetMapping("listarby/{id}")
    public ResponseEntity<VentasEntity> findbyid(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(ventasService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<VentasEntity> crear(
            @RequestBody @Validated VentasDTO objRegistrar){
        try{
            VentasEntity obj = ventasService.save(objRegistrar);
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
            ventasService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Registro eliminado: "+ id);
        }catch(Exception e){
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VentasEntity> actualizar(
            @PathVariable("id") Integer id,
            @RequestBody @Validated VentasDTO venta) {
        try {
            VentasEntity actualizado = ventasService.update(id, venta);
            ResponseEntity.status(200);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
