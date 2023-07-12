package com.dione.npjavaserver.dao;

import com.dione.npjavaserver.model.Charac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// CharacDao.java

@Repository
public interface CharacDAO extends JpaRepository<Charac, Long> {

    List<Charac> findByFather(Charac charac);

    List<Charac> findByMother(Charac charac);

    List<Charac> findByMotherOrFather(Charac parentCharacter, Charac parentCharacter1);
}
