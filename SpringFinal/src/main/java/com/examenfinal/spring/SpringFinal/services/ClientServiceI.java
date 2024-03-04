package com.examenfinal.spring.SpringFinal.services;

import com.examenfinal.spring.SpringFinal.models.Client;

import java.util.HashMap;
import java.util.List;

public interface ClientServiceI {

    /** metodo para insertar un cliente en la bbdd */
    Client insertarCliente(Client client);

    /** metodo para obtener un cliente de la bbdd */
    Client getCliente(Long id);

    /** Metodo para obtener una lista de los clientes que han comprado mas que la cantidad proporcionada*/
    List<Client> listarMejoresClientes(Long quantity);

    /** Devuelve las estadisticas de todos los clientes */
    HashMap<String,String> estadisticas();
}
