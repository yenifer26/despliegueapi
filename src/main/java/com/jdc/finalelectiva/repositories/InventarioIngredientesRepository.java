package com.jdc.finalelectiva.repositories;

import com.jdc.finalelectiva.entity.InventarioIngredientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioIngredientesRepository  extends JpaRepository<InventarioIngredientesEntity, Integer> {
}
