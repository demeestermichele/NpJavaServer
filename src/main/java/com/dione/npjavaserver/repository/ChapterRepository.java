package com.dione.npjavaserver.repository;

import com.dione.npjavaserver.model.Chapter;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ChapterRepository extends CrudRepository<Chapter, Integer> {

    public Chapter findChapterById(Integer id);

    public Set<Chapter> findChaptersByNameContaining(String name);

    public Chapter findChaptersByNumber(Integer chapterNumber);


}
