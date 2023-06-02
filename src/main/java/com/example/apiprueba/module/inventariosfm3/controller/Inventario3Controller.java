package com.example.apiprueba.module.inventariosfm3.controller;


import com.example.apiprueba.module.inventariosfm3.entity.Inventario3Entity;
import com.example.apiprueba.module.inventariosfm3.service.IInventario3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api/v1/farm3/inventario")
public class Inventario3Controller {

    @Autowired
    private IInventario3Service inventarioService;

    @PostMapping(path = "/insertMedic",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Inventario3Entity> insertMedicamento(@RequestBody Inventario3Entity medicamento) {

        Inventario3Entity medic =  inventarioService.save(medicamento);

        if (medic != null) {
            return new ResponseEntity<>(medic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(path = "/all",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Inventario3Entity>> allInventario (Model model) {

        List<Inventario3Entity> list = inventarioService.findAllInventario();
        if (!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping(path = "/byId",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Inventario3Entity> searchMedicById (@RequestBody Long idMedic) {

        Inventario3Entity medic = new Inventario3Entity();
        medic =  inventarioService.findById(idMedic);

        if (!medic.getDescripcion().isEmpty()){
            return new ResponseEntity<>(medic, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(path = "/findbyClave",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Inventario3Entity> searchMedicByClave(@RequestParam("clave") String clave) {

        Inventario3Entity medic = new Inventario3Entity();
        medic =  inventarioService.findByClave(clave);

        if (!medic.getDescripcion().isEmpty()){
            return new ResponseEntity<>(medic, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
