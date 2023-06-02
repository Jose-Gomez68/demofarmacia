package com.example.apiprueba.module.inventariosfm3.service.impl;

import com.example.apiprueba.module.inventariosfm3.entity.Inventario3Entity;
import com.example.apiprueba.module.inventariosfm3.repository.IInventario3Repository;
import com.example.apiprueba.module.inventariosfm3.service.IInventario3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class Inventario3ServiceJpa implements IInventario3Service {

    @Autowired
    private IInventario3Repository repository;

    @Override
    public List<Inventario3Entity> findAllInventario() {
        return repository.findAll();
    }

    @Override
    public Inventario3Entity findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Inventario3Entity findByClave(String clave) {
        return repository.findByClave(clave);
    }

    @Override
    public Inventario3Entity save(Inventario3Entity medicamento) {
        return repository.save(medicamento);
    }
}
