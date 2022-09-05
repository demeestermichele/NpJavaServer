package com.dione.npjavaserver.controller;

import com.dione.npserver.model.Chapter;
import com.dione.npserver.repository.ChapterRepository;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/chapters")
@CrossOrigin(origins = "*")
public class ChapterController {

    @Autowired
    private ChapterRepository chapterRepository;

    @PostMapping("/add")
    public String addChapter(@RequestParam String name, @RequestParam Integer number, @RequestParam String description) {
        Chapter chapter = new Chapter();
        chapter.setName(name);
        chapter.setNumber(number);
        chapter.setDescription(description);
        chapterRepository.save(chapter);
        return "Chapter added!";
    }

    @GetMapping("/list")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public Iterable<Chapter> getChapters() {
        return chapterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Chapter findChapterById(@PathVariable Long id) {
        return chapterRepository.findChapterById(id);
    }

    @GetMapping("/{number}")
    public Chapter findChapterByNumber(@PathVariable float number) {
        return chapterRepository.findChaptersByNumber(number);
    }

    @GetMapping("/{name}")
    public Set<Chapter> findChapterByName(@PathVariable String name){
        return chapterRepository.findChaptersByNameContaining(name);
    }

   /* @GetMapping("/{characters}")
    public List<Chapter> findChapterByCharacterListContaining(@PathVariable List<Character> characters){
        return chapterRepository.findChaptersByCharactersListContaining(characters);
    }*/
}
