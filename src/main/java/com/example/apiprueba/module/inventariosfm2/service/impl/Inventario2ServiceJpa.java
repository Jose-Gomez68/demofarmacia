package com.example.apiprueba.module.inventariosfm2.service.impl;

import com.example.apiprueba.module.inventariosfm2.entity.Inventario2Entity;
import com.example.apiprueba.module.inventariosfm2.repository.IInventario2Repository;
import com.example.apiprueba.module.inventariosfm2.service.IInventario2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class Inventario2ServiceJpa implements IInventario2Service {

    @Autowired
    private IInventario2Repository repository;

    @Override
    public List<Inventario2Entity> findAllInventario() {
        return repository.findAll();
    }

    @Override
    public Inventario2Entity findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Inventario2Entity findByClave(String clave) {
        return repository.findByClave(clave);
    }

    @Override
    public Inventario2Entity save(Inventario2Entity medicamento) {
        return repository.save(medicamento);
    }
}
