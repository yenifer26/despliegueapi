package com.jdc.finalelectiva.rest;

import com.jdc.finalelectiva.dto.IngredientesProductoDTO;
import com.jdc.finalelectiva.entity.IngredientesProductoEntity;
import com.jdc.finalelectiva.service.IIngredientesProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredienteProducto")
public class IngredientesProductoRest {

    @Autowired
    private IIngredientesProductoService ingredientesProductoService;

    @GetMapping("listar")
    public ResponseEntity<List<IngredientesProductoEntity>> findAll() {
        return ResponseEntity.ok(ingredientesProductoService.findAll());
    }

    @GetMapping("listarby/{id}")
    public ResponseEntity<IngredientesProductoEntity> findbyid(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(ingredientesProductoService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<IngredientesProductoEntity> crear(
            @RequestBody @Validated IngredientesProductoDTO objRegistrar){
        try{
            IngredientesProductoEntity obj = ingredientesProductoService.save(objRegistrar);
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
            ingredientesProductoService.delete(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok("Registro eliminado: "+ id);
        }catch(Exception e){
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<IngredientesProductoEntity> actualizar(
            @PathVariable("id") Integer id,
            @RequestBody @Validated IngredientesProductoDTO inpro) {
        try {
            IngredientesProductoEntity actualizado = ingredientesProductoService.update(id, inpro);
            ResponseEntity.status(200);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            System.out.println("El error es: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
