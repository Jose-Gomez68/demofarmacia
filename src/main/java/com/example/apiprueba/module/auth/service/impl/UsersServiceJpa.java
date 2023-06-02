package com.example.apiprueba.module.auth.service.impl;

import com.example.apiprueba.module.auth.entity.UsersEntity;
import com.example.apiprueba.module.auth.repository.IUsersRepository;
import com.example.apiprueba.module.auth.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UsersServiceJpa implements IUsersService {

    @Autowired
    private IUsersRepository repository;

   /* @Override
    public void saveUsers(UsersEntity users) {
        repository.save(users);
    }

    @Override
    public void deleteUser(Long idUser) {
        repository.deleteById(idUser);
    }*/

    @Override
    public List<UsersEntity> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public UsersEntity searchLogin(String email, String pass) {
        return repository.findByEmailAndPass(email, pass);
    }
}
