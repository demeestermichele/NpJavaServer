package com.dione.npjavaserver.controller;

import com.dione.npjavaserver.dto.ChapterDTO;
import com.dione.npjavaserver.model.Book;
import com.dione.npjavaserver.service.ChapterService;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/chapter")
@CrossOrigin(origins = "*")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    /**
     * List of all Characters
     **/
    @GetMapping("/")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public ResponseEntity<List<ChapterDTO>> getAll() {
        List<ChapterDTO> chapterDTOList = chapterService.getAll();
        return ResponseEntity.ok(chapterDTOList);
    }

    /**
     * Get 1 Character using ID
     **/
    @GetMapping("/{id}")
    public ResponseEntity<ChapterDTO> findChapterById(@PathVariable Long id) {
        ChapterDTO chapterDTO = null;
        try {
            chapterDTO = chapterService.getChapterById(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(chapterDTO);
    }


    /**
     * Create 1 Character
     **/
    @PostMapping("")
    public ResponseEntity<ChapterDTO> createChapter(@RequestBody ChapterDTO chapterDTO) {
        ChapterDTO createdChapterDTO = chapterService.createChapter(chapterDTO);
        return ResponseEntity.created(URI.create("/chapter/" + createdChapterDTO.getName())).body(createdChapterDTO);

    }

    @GetMapping("/book/{bookIndex}")
    public ResponseEntity<List<ChapterDTO>> findChaptersByBook(@PathVariable Book bookIndex) throws ChangeSetPersister.NotFoundException {
        List<ChapterDTO> chapterDTOList = chapterService.getChapterByBook(bookIndex);
        return ResponseEntity.ok(chapterDTOList);


/*    @GetMapping("/{name}")
    public Set<Chapter> findChapterByName(@PathVariable String name){
        return chapterService.findChaptersByNameContaining(name);
    }*/

    }
}
