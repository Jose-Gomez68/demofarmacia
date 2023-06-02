package com.example.apiprueba.module.inventariosfm4.service;

import com.example.apiprueba.module.inventariosfm3.entity.Inventario3Entity;
import com.example.apiprueba.module.inventariosfm4.entity.Inventario4Entity;

import java.util.List;

public interface IInventario4Service {

    List<Inventario4Entity> findAllInventario ();

    Inventario4Entity findById(Long id);

    Inventario4Entity findByClave(String clave);

    Inventario4Entity save(Inventario4Entity medicamento);

}
