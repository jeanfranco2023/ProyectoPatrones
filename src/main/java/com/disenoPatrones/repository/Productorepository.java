package com.disenoPatrones.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disenoPatrones.entity.producto;

public interface Productorepository extends JpaRepository<producto, Integer> {
    Optional<producto> findByCodigoProducto(String codigoProducto);

    Optional<producto> findByNombreProducto(String nombreProducto);

}
