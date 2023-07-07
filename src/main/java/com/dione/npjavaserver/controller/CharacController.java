package com.dione.npjavaserver.controller;

import com.dione.npjavaserver.dto.ChapterDTO;
import com.dione.npjavaserver.dto.CharacDTO;
import com.dione.npjavaserver.model.Chapter;
import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.service.ChapterService;
import com.dione.npjavaserver.service.CharacService;
import com.dione.npjavaserver.service.CharacServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/characters")
@CrossOrigin("*")
public class CharacController {

    @Autowired
    private CharacService characService;

    @Autowired
    private ChapterService chapterService;

    private CharacServiceImpl characterServiceImpl;

    /**
     * List of all Characters
     **/
    @GetMapping("/")
    public ResponseEntity<List<CharacDTO>> getAll() throws ChangeSetPersister.NotFoundException {
        List<CharacDTO> characDTOs = characService.getAll();
        return ResponseEntity.ok(characDTOs);
    }

    /**
     * Get 1 Character using ID
     **/
    @GetMapping("/{id}")
    public ResponseEntity<CharacDTO> getCharacById(@PathVariable Long id) {
        CharacDTO characDto = null;
        try {
            characDto = characService.getCharacById(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(characDto);
    }

    /**
     * Create 1 Character
     **/
    @PostMapping("/create")
    public ResponseEntity<CharacDTO> createCharac(@RequestBody CharacDTO characDto) throws ChangeSetPersister.NotFoundException {
        CharacDTO createdCharacDto = characService.createCharac(characDto);
        return ResponseEntity.created(URI.create("/charac/" + createdCharacDto.getId())).body(createdCharacDto);
    }

    /**
     * Update 1 Character after finding ID
     **/
    @PutMapping("/{id}")
    public ResponseEntity<CharacDTO> updateCharac(@PathVariable Long id, @RequestBody CharacDTO characDto) {
        CharacDTO updatedCharacDto = null;
        try {
            updatedCharacDto = characService.updateCharac(id, characDto);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(updatedCharacDto);
    }

    /**
     * Delete 1 Character using ID
     **/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharac(@PathVariable Long id) {
        try {
            characService.deleteCharac(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.noContent().build();
    }

    /**
     * finds the mother and the father of one character using character ID
     *
     * @param id character ID
     * @return json of motherDTO and fatherDTO with their respective parents
     * @throws ChangeSetPersister.NotFoundException
     */
    @GetMapping("/{id}/parents")
    public ResponseEntity<List<CharacDTO>> getParents(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        CharacDTO charac = characService.getCharacById(id);
        List<CharacDTO> parents = new ArrayList<>();
        CharacDTO maternalGrandparents = characService.getCharacById(charac.getMother().getId());
        CharacDTO paternalGrandparents = characService.getCharacById(charac.getFather().getId());
        parents.add(maternalGrandparents);
        parents.add(paternalGrandparents);
        return ResponseEntity.ok(parents);
    }

    /**
     * Using the ID of a character, display all Chapters in which they are present
     *
     * @param id of the character whose chapter list you wish to find.
     * @return list of chapters
     */
    @GetMapping("/{id}/chapters")
    public ResponseEntity<List<ChapterDTO>> getChaptersByCharacId(@PathVariable Long id) {
        try {
            List<ChapterDTO> chapters = chapterService.getChaptersByCharacterId(id);
            return ResponseEntity.ok(chapters);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
