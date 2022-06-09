package com.example.trening.dao;

import com.example.trening.model.Cwiczenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CwiczenieDao extends JpaRepository<Cwiczenie, Integer> {


    @Query(value = "SELECT * FROM cwiczenie WHERE treningID = ?1",
            nativeQuery = true)
    public List<Cwiczenie> znajdzCwiczeniaZTreningu(int id);
}
