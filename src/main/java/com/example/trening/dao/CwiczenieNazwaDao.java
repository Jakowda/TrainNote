package com.example.trening.dao;

import com.example.trening.model.NazwaCwiczenia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CwiczenieNazwaDao extends JpaRepository<NazwaCwiczenia, Integer> {
}
