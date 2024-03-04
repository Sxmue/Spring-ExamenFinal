package com.examenfinal.spring.SpringFinal.services;

import com.examenfinal.spring.SpringFinal.models.Client;
import com.examenfinal.spring.SpringFinal.models.ClientRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientServiceI{

    final
    ClientRepositoryI clientRepositoryI;

    @Autowired
    public ClientServiceImpl(ClientRepositoryI clientRepositoryI) {
        this.clientRepositoryI = clientRepositoryI;
    }

    @Override
    public Client insertarCliente(Client client) {

       return  clientRepositoryI.save(client);

    }

    @Override
    public Client getCliente(Long id) {

        Client result = new Client();

        Optional<Client> c = clientRepositoryI.findById(id);

        if (c.isPresent()){
            result.setId(c.get().getId());
            result.setName(c.get().getName());
            result.setTotalSales(c.get().getTotalSales());
            result.setState(c.get().getState());
        }

       return  result;

    }

    @Override
    public List<Client> listarMejoresClientes(Long quantity){

        return clientRepositoryI.findByTotalSalesGreaterThan(quantity);
    }

    @Override
    public HashMap<String,String> estadisticas() {

        HashMap hm = new HashMap();

        hm.put("total",clientRepositoryI.getTotalSales());

        hm.put("promedio",clientRepositoryI.getAvgActives());

        hm.put("inactivos",clientRepositoryI.getInactives());


        return hm;
    }
}
