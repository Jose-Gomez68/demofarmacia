package com.example.apiprueba.module.auth.repository;

import com.example.apiprueba.module.auth.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsersRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity findByEmailAndPass(String email, String pass);

}
