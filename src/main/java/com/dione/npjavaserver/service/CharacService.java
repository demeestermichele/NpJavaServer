package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.CharacDto;
import com.dione.npjavaserver.model.Charac;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CharacService {
    List<CharacDto> getAll();

    CharacDto getCharacById(Long id) throws ChangeSetPersister.NotFoundException;

    CharacDto createCharac(CharacDto characDto);

    CharacDto updateCharac(Long id, CharacDto characDto) throws ChangeSetPersister.NotFoundException;

    void deleteCharac(Long id) throws ChangeSetPersister.NotFoundException;
}
