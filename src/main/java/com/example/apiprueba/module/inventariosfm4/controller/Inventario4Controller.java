package com.example.apiprueba.module.inventariosfm4.controller;

import com.example.apiprueba.module.inventariosfm4.entity.Inventario4Entity;
import com.example.apiprueba.module.inventariosfm4.service.IInventario4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api/v1/farm4/inventario")
public class Inventario4Controller {

    @Autowired
    private IInventario4Service inventarioService;

    @PostMapping(path = "/insertMedic",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Inventario4Entity> insertMedicamento(@RequestBody Inventario4Entity medicamento) {

        Inventario4Entity medic =  inventarioService.save(medicamento);

        if (medic != null) {
            return new ResponseEntity<>(medic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(path = "/all",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Inventario4Entity>> allInventario (Model model) {

        List<Inventario4Entity> list = inventarioService.findAllInventario();
        if (!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping(path = "/byId",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Inventario4Entity> searchMedicById (@RequestBody Long idMedic) {

        Inventario4Entity medic = new Inventario4Entity();
        medic =  inventarioService.findById(idMedic);

        if (!medic.getDescripcion().isEmpty()){
            return new ResponseEntity<>(medic, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(path = "/findbyClave",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Inventario4Entity> searchMedicByClave(@RequestParam("clave") String clave) {

        Inventario4Entity medic = new Inventario4Entity();
        medic =  inventarioService.findByClave(clave);

        if (!medic.getDescripcion().isEmpty()){
            return new ResponseEntity<>(medic, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
