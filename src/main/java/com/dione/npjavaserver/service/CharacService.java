package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dto.CharacDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CharacService {
    List<CharacDTO> getAll() throws ChangeSetPersister.NotFoundException;

    CharacDTO getCharacById(Long id) throws ChangeSetPersister.NotFoundException;

    CharacDTO createCharac(CharacDTO characDto);

    CharacDTO updateCharac(Long id, CharacDTO characDto) throws ChangeSetPersister.NotFoundException;

    void deleteCharac(Long id) throws ChangeSetPersister.NotFoundException;


}

