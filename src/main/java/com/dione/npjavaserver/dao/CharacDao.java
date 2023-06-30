package com.dione.npjavaserver.dao;

import com.dione.npjavaserver.dto.CharacDto;
import com.dione.npjavaserver.model.Charac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// CharacDao.java

@Repository
public interface CharacDao extends JpaRepository<Charac, Long> {}
