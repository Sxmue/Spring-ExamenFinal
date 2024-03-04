package com.examenfinal.spring.SpringFinal.controllers;


import com.examenfinal.spring.SpringFinal.models.Client;
import com.examenfinal.spring.SpringFinal.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Examen")
public class MainController {

    final ClientServiceImpl clientService;


    @Autowired
    public MainController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }






    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client c){

        ResponseEntity<Client> response = null;

        Client result = clientService.insertarCliente(c);

        if(result != null){

            response = new ResponseEntity<>(result,HttpStatus.OK);
        }else {

            response = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        }

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        ResponseEntity<Client> response = null;

        Client c =  clientService.getCliente(id);

        if (c != null) {
            response = new ResponseEntity<>(c,HttpStatus.OK);

        } else {

            response = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        }


        return response;
    }


    @GetMapping("/best/{sales}")
    public ResponseEntity<List<Client>> getBestClients(@PathVariable Long sales){
        ResponseEntity<List<Client>> response = null;

        List<Client> list = clientService.listarMejoresClientes(sales);

        if (!list.isEmpty()){

            response = new ResponseEntity<>(list,HttpStatus.OK);

        }else {

            response = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        }

        return response;
    }


    @GetMapping("/stats")
    public ResponseEntity<HashMap> getStats(){

        ResponseEntity<HashMap> response = null;

        HashMap hm = clientService.estadisticas();

        if(!hm.isEmpty()){

            response = new ResponseEntity<>(hm,HttpStatus.OK);

        }else {

            response = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        }


        return response;
    }



}
