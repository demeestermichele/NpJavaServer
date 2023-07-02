package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.CharacDAO;
import com.dione.npjavaserver.dto.CharacDto;
import com.dione.npjavaserver.model.Charac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacServiceImpl implements CharacService {

    @Autowired
    private CharacDAO characDao;


    @Override
    public List<CharacDto> getAll() {
        List<Charac> characs= characDao.findAll();
        List<CharacDto> characDTOList = new ArrayList<>();
        for (Charac charac : characs) {
            characDTOList.add(new CharacDto(charac.getId(), charac.getFirstName(), charac.getLastName(), charac.getSex()));
        }
        return characDTOList;
    }

    @Override
    public CharacDto getCharacById(Long id) throws NotFoundException {
        Charac charac = characDao.findById(id).orElseThrow(NotFoundException::new);
        return mapToDto(charac);
    }

    @Override
    public CharacDto createCharac(CharacDto characDto) {
        Charac charac = mapToEntity(characDto);
        Charac createdCharac = characDao.save(charac);
        return mapToDto(createdCharac);
    }

    @Override
    public CharacDto updateCharac(Long id, CharacDto characDto) throws NotFoundException {
        Charac charac = characDao.findById(id).orElseThrow(NotFoundException::new);
        charac.setFirstName(characDto.getFirstName());
        charac.setLastName(characDto.getLastName());
        Charac updatedCharac = characDao.save(charac);
        return mapToDto(updatedCharac);
    }

    @Override
    public void deleteCharac(Long id) throws NotFoundException {
        Charac charac = characDao.findById(id).orElseThrow(NotFoundException::new);
        characDao.delete(charac);
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
