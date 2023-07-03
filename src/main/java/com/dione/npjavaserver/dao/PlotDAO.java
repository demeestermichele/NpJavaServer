package com.dione.npjavaserver.dao;

import com.dione.npjavaserver.model.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotDAO extends JpaRepository<Plot, Long> {
}
