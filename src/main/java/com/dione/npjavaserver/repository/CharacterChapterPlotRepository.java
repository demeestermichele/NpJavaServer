package com.dione.npjavaserver.repository;

import com.dione.npjavaserver.model.Chapter;
import com.dione.npjavaserver.model.Charac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterChapterPlotRepository extends JpaRepository<Charac, Chapter> {

}
