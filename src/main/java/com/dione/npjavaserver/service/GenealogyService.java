package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.CharacDto;
import com.dione.npjavaserver.dto.GenealogyDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GenealogyService {
    List<GenealogyDto> getAll();

    CharacDto getCharacGenealogyById(Long id) throws ChangeSetPersister.NotFoundException;

    GenealogyDto createCharacGenealogy(GenealogyDto genealogyDto);

    GenealogyDto updateCharacGenealogy(Long id, GenealogyDto genealogyDto) throws ChangeSetPersister.NotFoundException;

    void deleteCharacGenealogy(Long id) throws ChangeSetPersister.NotFoundException;
}
