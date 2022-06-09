package com.example.trening.dao;

import com.example.trening.model.Seria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface SeriaDao extends JpaRepository<Seria, Integer> {

    @Query(value = "SELECT * FROM serie WHERE cwiczenieID = ?1",
            nativeQuery = true)
    public List<Seria> znajdzSerieDanegoCwiczenia(int id);

}
