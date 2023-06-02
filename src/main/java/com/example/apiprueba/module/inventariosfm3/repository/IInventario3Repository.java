package com.example.apiprueba.module.inventariosfm3.repository;


import com.example.apiprueba.module.inventariosfm3.entity.Inventario3Entity;
import com.example.apiprueba.module.inventariosfm4.entity.Inventario4Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventario3Repository extends JpaRepository<Inventario3Entity, Long> {

    Inventario3Entity findByClave(String clave);

}
