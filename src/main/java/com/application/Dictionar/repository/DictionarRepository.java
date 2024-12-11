package com.application.Dictionar.repository;

import com.application.Dictionar.entity.Dictionar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionarRepository extends JpaRepository<Dictionar, Integer> {

    public boolean existsByRomanian(String romanian);

    public List<Dictionar> findByRomanian(String romanian);

    @Query("select max(s.id) from Dictionar s")
    public Integer findMaxId();
}
