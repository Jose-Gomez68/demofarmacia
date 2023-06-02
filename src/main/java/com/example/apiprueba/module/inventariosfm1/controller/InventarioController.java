package com.example.apiprueba.module.inventariosfm1.controller;

import com.example.apiprueba.module.inventariosfm1.entity.InventarioEntity;
import com.example.apiprueba.module.inventariosfm1.service.IInventarioService;
import com.example.apiprueba.module.inventariosfm2.entity.Inventario2Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api/v1/farm1/inventario")
public class InventarioController {

    @Autowired
    private IInventarioService inventarioService;

    @PostMapping(path = "/insertMedic",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<InventarioEntity> insertMedicamento(@RequestBody InventarioEntity medicamento) {

        InventarioEntity medic =  inventarioService.save(medicamento);

        if (medic != null) {
            return new ResponseEntity<>(medic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(path = "/all",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<InventarioEntity>> allInventario (Model model) {

        List<InventarioEntity> list = inventarioService.findAllInventario();
        if (!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping(path = "/byId",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<InventarioEntity> searchMedicById (@RequestBody Long idMedic) {

        InventarioEntity medic = new InventarioEntity();
        medic =  inventarioService.findById(idMedic);

        if (!medic.getDescripcion().isEmpty()){
            return new ResponseEntity<>(medic, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(path = "/findbyClave",produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<InventarioEntity> searchMedicByClave(@RequestParam("clave") String clave) {
        System.out.println(clave);
        InventarioEntity medic = inventarioService.findByClave(clave);

        if (medic != null && medic.getDescripcion() != null && !medic.getDescripcion().isEmpty()) {
            return new ResponseEntity<>(medic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
