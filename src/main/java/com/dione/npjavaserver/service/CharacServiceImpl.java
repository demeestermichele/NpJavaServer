package com.dione.npjavaserver.service;

import com.dione.npjavaserver.dao.CharacDAO;
import com.dione.npjavaserver.dto.CharacDTO;
import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.model.Sex;
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
    public List<CharacDTO> getAll() throws NotFoundException {
        List<Charac> characs = characDAO.findAll();
        List<CharacDTO> characDTOList = new ArrayList<>();

        for (Charac charac : characs) {

            CharacDTO motherDTO = new CharacDTO(charac.getMother().getId(), charac.getMother().getFirstName(), charac.getMother().getLastName(), charac.getMother().getSex());

            CharacDTO fatherDTO = new CharacDTO(charac.getFather().getId(), charac.getFather().getFirstName(), charac.getFather().getLastName(), charac.getFather().getSex());

            characDTOList.add(new CharacDTO(charac.getId(), charac.getFirstName(), charac.getLastName(), charac.getSex(), fatherDTO, motherDTO));

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

    @Override
    public List<CharacDTO> getChildrenByParentId(Long id) throws NotFoundException {
        Charac parentCharacter = characDAO.findById(id).orElseThrow(NotFoundException::new);
        List<Charac> characs = characDAO.findByMotherOrFather(parentCharacter, parentCharacter);
        List<CharacDTO> childrenDTOList = new ArrayList<>();

        for (Charac charac : characs) {

            if (parentCharacter.getSex() == Sex.MALE) {
                Charac mother = new Charac();
                mother.setFirstName(charac.getMother().getFirstName());
                charac.setMother(mother);
                charac.setFather(null);
                childrenDTOList.add(mapToDto(charac));
            } else if (parentCharacter.getSex() == Sex.FEMALE){
                Charac dad = new Charac();
                dad.setFirstName(charac.getFather().getFirstName());
                charac.setFather(dad);
                charac.setMother(null);
                childrenDTOList.add(mapToDto(charac));
            }
        }
        System.out.println(childrenDTOList);
        return childrenDTOList;
    }

    private CharacDTO mapToShortDto(Charac charac) {
        CharacDTO characDto = new CharacDTO();
        characDto.setId(charac.getId());
        characDto.setFirstName(charac.getFirstName());
        characDto.setLastName(charac.getLastName());
        characDto.setSex(charac.getSex());

        return characDto;
    }

    private CharacDTO mapToDto(Charac charac) {
        CharacDTO characDto = new CharacDTO();
        characDto.setId(charac.getId());
        characDto.setFirstName(charac.getFirstName());
        characDto.setLastName(charac.getLastName());
        characDto.setSex(charac.getSex());

        Charac mother = charac.getMother();
        if (mother != null) {
            CharacDTO motherDto = new CharacDTO();
            motherDto.setId(mother.getId());
            motherDto.setFirstName(mother.getFirstName());
            motherDto.setLastName(mother.getLastName());
            motherDto.setSex(mother.getSex());
            characDto.setMother(motherDto);
        }

        Charac father = charac.getFather();
        if (father != null) {
            CharacDTO fatherDto = new CharacDTO();
            fatherDto.setId(father.getId());
            fatherDto.setFirstName(father.getFirstName());
            fatherDto.setLastName(father.getLastName());
            fatherDto.setSex(father.getSex());
            characDto.setFather(fatherDto);
        }
        return characDto;
    }
    private Charac mapToShortEntity(CharacDTO characDto) {
        Charac charac = new Charac();
        charac.setFirstName(characDto.getFirstName());
        charac.setLastName(characDto.getLastName());
        charac.setSex(charac.getSex());
        return charac;
    }


    private Charac mapToEntity(CharacDTO characDto) {
        Charac charac = new Charac();
        charac.setFirstName(characDto.getFirstName());
        charac.setLastName(characDto.getLastName());
        charac.setSex(charac.getSex());

        CharacDTO motherDto = characDto.getMother();
        if (motherDto != null) {
            Charac mother = new Charac();
            motherDto.setId(mother.getId());
            motherDto.setFirstName(mother.getFirstName());
            motherDto.setLastName(mother.getLastName());
            motherDto.setSex(mother.getSex());
            charac.setMother(mother);
        }

        CharacDTO fatherDto = characDto.getFather();
        if (fatherDto != null) {
            Charac father = new Charac();
            father.setId(fatherDto.getId());
            father.setFirstName(fatherDto.getFirstName());
            father.setLastName(fatherDto.getLastName());
            father.setSex(fatherDto.getSex());
            charac.setFather(father);
        }
        return charac;
    }
}
