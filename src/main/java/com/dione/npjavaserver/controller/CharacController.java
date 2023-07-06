package com.dione.npjavaserver.controller;

import com.dione.npjavaserver.dto.CharacDTO;
import com.dione.npjavaserver.service.CharacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/characters")
@CrossOrigin("*")
public class CharacController {

    @Autowired
    private CharacService characService;

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

    //TODO
    @GetMapping("/{id}/parents")
    public ResponseEntity<List<CharacDTO>> getParents(@PathVariable Long id){
        return null;
    }
}
