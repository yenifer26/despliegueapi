package com.jdc.finalelectiva.rest;


import com.jdc.finalelectiva.dto.IngredientesDTO;
import com.jdc.finalelectiva.entity.IngredientesEntity;
import com.jdc.finalelectiva.service.IIngredientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingrediente")
public class IngredientesRest {

    @Autowired
    private IIngredientesService ingredientesService;

    @GetMapping("listar")
    public ResponseEntity<List<IngredientesEntity>> findAll() {
        return ResponseEntity.ok(ingredientesService.findAll());
    }

    @GetMapping("listarby/{id}")
    public ResponseEntity<IngredientesEntity> findbyid(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(ingredientesService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<IngredientesEntity> crear(
            @RequestBody @Validated IngredientesDTO objRegistrar){
        try{
            IngredientesEntity obj = ingredientesService.save(objRegistrar);
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
            ingredientesService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Registro eliminado: "+ id);
        }catch(Exception e){
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<IngredientesEntity> actualizar(
            @PathVariable("id") Integer id,
            @RequestBody @Validated IngredientesDTO ingre) {
        try {
            IngredientesEntity actualizado = ingredientesService.update(id, ingre);
            ResponseEntity.status(200);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
