package com.example.sklep.warehouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Integer> {
    Optional<WarehouseEntity> findByProductEntityProductId(int productId);
}
