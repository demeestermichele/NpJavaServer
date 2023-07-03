package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.CharacDAO;
import com.dione.npjavaserver.dto.CharacDTO;
import com.dione.npjavaserver.model.Charac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacServiceImpl implements CharacService {

    @Autowired
    private CharacDAO characDAO;


    @Override
    public List<CharacDTO> getAll() {
        List<Charac> characs= characDAO.findAll();
        List<CharacDTO> characDTOList = new ArrayList<>();
        for (Charac charac : characs) {
            characDTOList.add(new CharacDTO(charac.getId(), charac.getFirstName(), charac.getLastName(), charac.getSex()));
        }
        return characDTOList;
    }

    @Override
    public CharacDTO getCharacById(Long id) throws NotFoundException {
        Charac charac = characDAO.findById(id).orElseThrow(NotFoundException::new);
        return mapToDto(charac);
    }

    @Override
    public CharacDTO createCharac(CharacDTO characDto) {
        Charac charac = mapToEntity(characDto);
        Charac createdCharac = characDAO.save(charac);
        return mapToDto(createdCharac);
    }

    @Override
    public CharacDTO updateCharac(Long id, CharacDTO characDto) throws NotFoundException {
        Charac charac = characDAO.findById(id).orElseThrow(NotFoundException::new);
        charac.setFirstName(characDto.getFirstName());
        charac.setLastName(characDto.getLastName());
        Charac updatedCharac = characDAO.save(charac);
        return mapToDto(updatedCharac);
    }

    @Override
    public void deleteCharac(Long id) throws NotFoundException {
        Charac charac = characDAO.findById(id).orElseThrow(NotFoundException::new);
        characDAO.delete(charac);
    }

    private CharacDTO mapToDto(Charac charac) {
        CharacDTO characDto = new CharacDTO();
        characDto.setId(charac.getId());
        characDto.setFirstName(charac.getFirstName());
        characDto.setLastName(charac.getLastName());
        characDto.setSex(charac.getSex());
        return characDto;
    }

    private Charac mapToEntity(CharacDTO characDto) {
        Charac charac = new Charac();
        charac.setFirstName(characDto.getFirstName());
        charac.setLastName(characDto.getLastName());
        charac.setSex(charac.getSex());
        return charac;
    }
}
