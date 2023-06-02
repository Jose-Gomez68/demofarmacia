package com.example.apiprueba.module.inventariosfm2.service;

import com.example.apiprueba.module.inventariosfm2.entity.Inventario2Entity;

import java.util.List;

public interface IInventario2Service {

    List<Inventario2Entity> findAllInventario ();

    Inventario2Entity findById(Long id);

    Inventario2Entity findByClave(String clave);

    Inventario2Entity save(Inventario2Entity medicamento);

}
