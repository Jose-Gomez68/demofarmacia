package com.example.apiprueba.module.inventariosfm1.repository;


import com.example.apiprueba.module.inventariosfm1.entity.InventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IInventarioRepository extends JpaRepository<InventarioEntity, Long> {

    InventarioEntity findByClave(String clave);

}
