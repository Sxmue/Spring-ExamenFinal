package com.examenfinal.spring.SpringFinal.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepositoryI extends JpaRepository<Client,Long> {

    List<Client> findByTotalSalesGreaterThan(Long quantity);

    @Query("SELECT sum(c.totalSales) FROM Client c ")
    public Long getTotalSales();

    @Query("SELECT Avg(c.totalSales) FROM Client c WHERE c.state = 'activo'")
    public Double getAvgActives();

    @Query("SELECT Count(c) FROM Client c WHERE c.state = 'inactivo' AND c.totalSales > 0  ")
    public Long getInactives();


}
