package com.example.apiprueba.module.inventariosfm2.controller;

import com.example.apiprueba.module.inventariosfm2.entity.Inventario2Entity;
import com.example.apiprueba.module.inventariosfm2.service.IInventario2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api/v1/farm2/inventario")
public class Inventario2Controller {

    @Autowired
    private IInventario2Service inventarioService;

    @PostMapping(path = "/insertMedic",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Inventario2Entity> insertMedicamento(@RequestBody Inventario2Entity medicamento) {

        Inventario2Entity medic =  inventarioService.save(medicamento);

        if (medic != null) {
            return new ResponseEntity<>(medic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(path = "/all",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Inventario2Entity>> allInventario (Model model) {

        List<Inventario2Entity> list = inventarioService.findAllInventario();
        if (!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping(path = "/byId",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Inventario2Entity> searchMedicById (@RequestBody Long idMedic) {

        Inventario2Entity medic = new Inventario2Entity();
        medic =  inventarioService.findById(idMedic);

        if (!medic.getDescripcion().isEmpty()){
            return new ResponseEntity<>(medic, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(path = "/findbyClave",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Inventario2Entity> searchMedicByClave(@RequestParam("clave") String clave) {

        Inventario2Entity medic = new Inventario2Entity();
        medic =  inventarioService.findByClave(clave);

        if (!medic.getDescripcion().isEmpty()){
            return new ResponseEntity<>(medic, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
