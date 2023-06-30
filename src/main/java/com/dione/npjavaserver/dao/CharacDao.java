package com.dione.npjavaserver.dao;

import com.dione.npjavaserver.model.Charac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacDao extends JpaRepository<Charac, Long> {}
