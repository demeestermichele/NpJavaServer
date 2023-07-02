package com.dione.npjavaserver.dao;

import com.dione.npjavaserver.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterDAO extends JpaRepository<Chapter, Long> {
}
