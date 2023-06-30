package com.dione.npjavaserver.controller;

import com.dione.npjavaserver.dto.CharacDto;
import com.dione.npjavaserver.dto.GenealogyDto;
import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.service.CharacService;
import com.dione.npjavaserver.service.GenealogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genealogy")
@CrossOrigin("*")
public class GenealogyController {

    @Autowired
    private GenealogyService genealogyService;

    @Autowired
    private CharacService characService;

    /**
     * List of all Characters
     **/
    @GetMapping("/")
    public ResponseEntity<List<GenealogyDto>> getAll() {
        List<GenealogyDto> characDTOs = genealogyService.getAll();
        return ResponseEntity.ok(characDTOs);
    }

    /**
     * Get 1 Character using ID
     **/
    @GetMapping("/{id}")
    public ResponseEntity<GenealogyDto> getCharacGenealogyById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        CharacDto characById= characService.getCharacById(id);
        GenealogyDto genealogyDto = null;
        CharacDto characDto = null;
        try {
            genealogyDto.getMother();
            genealogyDto.getFather();
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(GenealogyDto);
    }


}
