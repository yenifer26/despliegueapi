package com.jdc.finalelectiva.rest;




import com.jdc.finalelectiva.dto.InventarioIngredientesDTO;
import com.jdc.finalelectiva.entity.InventarioIngredientesEntity;
import com.jdc.finalelectiva.service.IInventarioIngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarioIngrediente")
public class InventarioIngredientesRest {

    @Autowired
    private IInventarioIngredientesService inventarioIngredientesService;

    @GetMapping("listar")
    public ResponseEntity<List<InventarioIngredientesEntity>> findAll() {
        return ResponseEntity.ok(inventarioIngredientesService.findAll());
    }

    @GetMapping("listarby/{id}")
    public ResponseEntity<InventarioIngredientesEntity> findbyid(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(inventarioIngredientesService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<InventarioIngredientesEntity> crear(
            @RequestBody @Validated InventarioIngredientesDTO objRegistrar){
        try{
            InventarioIngredientesEntity obj = inventarioIngredientesService.save(objRegistrar);
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
            inventarioIngredientesService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Registro eliminado: "+ id);
        }catch(Exception e){
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InventarioIngredientesEntity> actualizar(
            @PathVariable("id") Integer id,
            @RequestBody @Validated InventarioIngredientesDTO ingre) {
        try {
            InventarioIngredientesEntity actualizado = inventarioIngredientesService.update(id, ingre);
            ResponseEntity.status(200);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
