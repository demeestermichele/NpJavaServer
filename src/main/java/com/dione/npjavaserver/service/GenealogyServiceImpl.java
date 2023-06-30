package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.CharacDao;
import com.dione.npjavaserver.dto.CharacDto;
import com.dione.npjavaserver.dto.GenealogyDto;
import com.dione.npjavaserver.model.Charac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenealogyServiceImpl implements GenealogyService {

    @Autowired
    private CharacDao characDao;


    @Override
    public List<GenealogyDto> getAll() {
        List<Charac> characs= characDao.findAll();
        List<GenealogyDto> characDTOList = new ArrayList<>();
        for (Charac charac : characs) {
            characDTOList.add(new GenealogyDto(charac.getMother(), charac.getFather()));
        }
        return characDTOList;
    }

    @Override
    public CharacDto getCharacGenealogyById(Long id) throws ChangeSetPersister.NotFoundException {
        Charac charac = characDao.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return mapToDto(charac);
    }

    @Override
    public GenealogyDto createCharacGenealogy(GenealogyDto genealogyDto) {
        return null;
    }

    @Override
    public GenealogyDto updateCharacGenealogy(Long id, GenealogyDto genealogyDto) throws ChangeSetPersister.NotFoundException {
        return null;
    }

    @Override
    public void deleteCharacGenealogy(Long id) throws ChangeSetPersister.NotFoundException {

    }

    private CharacDto mapToDto(Charac charac) {
        CharacDto characDto = new CharacDto();
        characDto.setId(charac.getId());
        characDto.setFirstName(charac.getFirstName());
        characDto.setLastName(charac.getLastName());
        characDto.setSex(charac.getSex());
        return characDto;
    }

    private Charac mapToEntity(CharacDto characDto) {
        Charac charac = new Charac();
        charac.setFirstName(characDto.getFirstName());
        charac.setLastName(characDto.getLastName());
        charac.setSex(charac.getSex());
        return charac;
    }
}
