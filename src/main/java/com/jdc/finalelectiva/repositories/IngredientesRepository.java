package com.jdc.finalelectiva.repositories;

import com.jdc.finalelectiva.entity.IngredientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientesRepository extends JpaRepository<IngredientesEntity, Integer> {
}
