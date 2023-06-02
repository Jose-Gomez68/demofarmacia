package com.example.apiprueba.module.inventariosfm1.service.impl;

import com.example.apiprueba.module.inventariosfm1.entity.InventarioEntity;
import com.example.apiprueba.module.inventariosfm1.repository.IInventarioRepository;
import com.example.apiprueba.module.inventariosfm1.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class InventarioServiceJpa implements IInventarioService {

    @Autowired
    private IInventarioRepository repository;

    @Override
    public List<InventarioEntity> findAllInventario() {
        return repository.findAll();
    }

    @Override
    public InventarioEntity findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public InventarioEntity findByClave(String clave) {
        return repository.findByClave(clave);
    }

    @Override
    public InventarioEntity save(InventarioEntity medicamento) {
        return repository.save(medicamento);
    }
}
