package com.example.apiprueba.module.auth.service;

import com.example.apiprueba.module.auth.entity.UsersEntity;

import java.util.List;

public interface IUsersService {

    /*void saveUsers (UsersEntity users);

    void deleteUser (Long idUser);*/

    List<UsersEntity> findAllUsers ();

    UsersEntity searchLogin (String email, String pass);

}
