package com.example.apiprueba.module.auth.controller;

import com.example.apiprueba.module.auth.dto.UsersLoginModel;
import com.example.apiprueba.module.auth.dto.UsersModel;
import com.example.apiprueba.module.auth.entity.UsersEntity;
import com.example.apiprueba.module.auth.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @GetMapping(path = "/all",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UsersEntity>> allUsers (Model model) {

        List<UsersEntity> list = usersService.findAllUsers();
        if (!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping(path = "/login",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersEntity> searchLogin (@RequestBody UsersLoginModel login) {

        UsersEntity user = new UsersEntity();
        user =  usersService.searchLogin(login.getEmail(), login.getPass());

        if (!user.getEmail().isEmpty()){

            return new ResponseEntity<>(user, HttpStatus.OK);

        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }



    }

}
