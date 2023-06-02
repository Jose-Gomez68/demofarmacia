package com.example.apiprueba.module.inventariosfm4.repository;


import com.example.apiprueba.module.inventariosfm4.entity.Inventario4Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventario4Repository extends JpaRepository<Inventario4Entity, Long> {

    Inventario4Entity findByClave(String clave);

}
