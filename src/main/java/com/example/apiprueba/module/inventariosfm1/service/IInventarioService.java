package com.example.apiprueba.module.inventariosfm1.service;

import com.example.apiprueba.module.inventariosfm1.entity.InventarioEntity;

import java.util.List;

public interface IInventarioService {

    List<InventarioEntity> findAllInventario ();

    InventarioEntity findById(Long id);

    InventarioEntity findByClave(String clave);

    InventarioEntity save(InventarioEntity medicamento);

}
