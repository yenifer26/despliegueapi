package com.jdc.finalelectiva.repositories;

import com.jdc.finalelectiva.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<ProductosEntity, Integer> {
}
