package com.example.trening.dao;

import com.example.trening.model.PostepSilowy;
import com.example.trening.model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TreningDao extends JpaRepository<Trening, Integer> {


    @Query(value = "CALL report_procedure(?1)",
            nativeQuery = true)
    public List<Object[]> znajdzPostepyWCwiczeniu(int nazwaCwiczeniaID);


    @Query(value = "SELECT * FROM trainote.trening  WHERE trening.uzytkownik_id=?1 ORDER BY trening.data_treningu;",
            nativeQuery = true)
    public List<Trening> znajdzWszystkiePosortowane(int uzytkownikID);
}
