package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.CharacDao;
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
    private CharacDao characDao;


    @Override
    public List<CharacDto> getAll() throws NotFoundException {
        List<Charac> characs = characDao.findAll();
        List<CharacDto> characDTOList = new ArrayList<>();
        for (Charac charac : characs) {
            characDTOList.add(new CharacDto(charac.getId(), charac.getFirstName(), charac.getLastName(), charac.getSex()));
        }
        return characDTOList;
    }

    @Override
    public CharacDto getMotherById(Long id) throws NotFoundException {
        Charac charac = characDao.findById(id).orElseThrow(NotFoundException::new);
        return mapToDto(charac.getMother());
    }

    @Override
    public CharacDto getFatherById(Long id) throws NotFoundException {
        Charac charac = characDao.findById(id).orElseThrow(NotFoundException::new);
        return mapToDto(charac.getFather());
    }


    @Override
    public CharacDto getCharacById(Long id) throws NotFoundException {
        Charac charac = characDao.findById(id).orElseThrow(NotFoundException::new);
        return mapToDto(charac);
    }

    @Override
    public CharacDto createCharac(CharacDto characDto) throws NotFoundException {
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

    private CharacDto mapToDto(Charac charac) throws NotFoundException {
        CharacDto characDto = new CharacDto();
        characDto.setId(charac.getId());
        characDto.setFirstName(charac.getFirstName());
        characDto.setLastName(charac.getLastName());
        characDto.setSex(charac.getSex());


        if (charac.getMother() != null) {
            CharacDto motherDto = new CharacDto();
            motherDto.setId(charac.getMother().getId());
            motherDto.setFirstName(charac.getMother().getFirstName());
            motherDto.setLastName(charac.getMother().getLastName());
            motherDto.setSex(charac.getMother().getSex());
            characDto.setMother(motherDto);
        }

        if (charac.getFather() != null) {
            CharacDto fatherDto = new CharacDto();
            fatherDto.setId(charac.getFather().getId());
            fatherDto.setFirstName(charac.getFather().getFirstName());
            fatherDto.setLastName(charac.getFather().getLastName());
            fatherDto.setSex(charac.getFather().getSex());
            characDto.setFather(fatherDto);
        }

        return characDto;
    }


    private Charac mapToEntity(CharacDto characDto) throws NotFoundException {
        Charac charac = new Charac();
        charac.setId(charac.getId());
        charac.setFirstName(characDto.getFirstName());
        charac.setLastName(characDto.getLastName());
        charac.setSex(characDto.getSex());

        CharacDto motherDto = characDto.getMother();
        if (motherDto != null) {
            Charac mother = mapToEntity(motherDto);
            charac.setMother(mother);
        }
        
        CharacDto fatherDto = characDto.getMother();
        if (fatherDto != null) {
            Charac father = mapToEntity(fatherDto);
            charac.setMother(father);
        }
        
        return charac;
    }
}
