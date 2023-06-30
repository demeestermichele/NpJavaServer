package com.dione.npjavaserver.repository;

import com.dione.npjavaserver.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

    public Chapter findChapterById(Long id);

    public Set<Chapter> findChaptersByNameContaining(String name);

    public Chapter findChaptersByNumber(float number);


}
