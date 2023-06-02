package com.example.apiprueba.module.inventariosfm4.service.impl;

import com.example.apiprueba.module.inventariosfm4.entity.Inventario4Entity;
import com.example.apiprueba.module.inventariosfm4.repository.IInventario4Repository;
import com.example.apiprueba.module.inventariosfm4.service.IInventario4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class Inventario4ServiceJpa implements IInventario4Service {

    @Autowired
    private IInventario4Repository repository;

    @Override
    public List<Inventario4Entity> findAllInventario() {
        return repository.findAll();
    }

    @Override
    public Inventario4Entity findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Inventario4Entity findByClave(String clave) {
        return repository.findByClave(clave);
    }

    @Override
    public Inventario4Entity save(Inventario4Entity medicamento) {
        return repository.save(medicamento);
    }
}
