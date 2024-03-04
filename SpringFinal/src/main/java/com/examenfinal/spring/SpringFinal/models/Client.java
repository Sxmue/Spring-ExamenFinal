package com.examenfinal.spring.SpringFinal.models;


import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;

/**
 * Clase que representa un cliente en la base de datos
 */
@Data
@Entity
@Table(name ="cliente")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "total")
    private Long totalSales;

    @Column(name = "estado")
    private String state;

    public Client() {
        totalSales = 0L;
        state = "active";
    }

    public Client(String name, Long totalSales, String state) {
        this.name = name;
        this.totalSales = totalSales;
        this.state = state;
    }
}
