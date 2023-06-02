package com.example.apiprueba.module.inventariosfm3.service;

import com.example.apiprueba.module.inventariosfm2.entity.Inventario2Entity;
import com.example.apiprueba.module.inventariosfm3.entity.Inventario3Entity;
import com.example.apiprueba.module.inventariosfm4.entity.Inventario4Entity;

import java.util.List;

public interface IInventario3Service {

    List<Inventario3Entity> findAllInventario ();

    Inventario3Entity findById(Long id);

    Inventario3Entity findByClave(String clave);

    Inventario3Entity save(Inventario3Entity medicamento);

}
