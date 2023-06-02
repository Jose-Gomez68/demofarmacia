package com.example.apiprueba.module.inventariosfm2.repository;


import com.example.apiprueba.module.inventariosfm2.entity.Inventario2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventario2Repository extends JpaRepository<Inventario2Entity, Long> {

    Inventario2Entity findByClave(String clave);

}
