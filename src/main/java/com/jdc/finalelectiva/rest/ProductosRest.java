package com.jdc.finalelectiva.rest;

import com.jdc.finalelectiva.dto.ProductosDTO;
import com.jdc.finalelectiva.entity.ProductosEntity;
import com.jdc.finalelectiva.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductosRest {

    @Autowired
    private IProductosService productosService;

    @GetMapping("listar")
    public ResponseEntity<List<ProductosEntity>> findAll() {
        return ResponseEntity.ok(productosService.findAll());
    }

    @GetMapping("listarby/{id}")
    public ResponseEntity<ProductosEntity> findbyid(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productosService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<ProductosEntity> crear(
            @RequestBody @Validated ProductosDTO objRegistrar){
        try{
            ProductosEntity obj = productosService.save(objRegistrar);
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
            productosService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Registro eliminado: "+ id);
        }catch(Exception e){
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductosEntity> actualizar(
            @PathVariable("id") Integer id,
            @RequestBody @Validated ProductosDTO prod) {
        try {
            ProductosEntity actualizado = productosService.update(id, prod);
            ResponseEntity.status(200);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
