package com.dione.npjavaserver.controller;

import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.model.Role;
import com.dione.npjavaserver.model.Sex;
import com.dione.npjavaserver.repository.CharacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/characters")
@CrossOrigin(origins = "*")
public class CharacterController {

    @Autowired
    private CharacRepository characRepository;
    @GetMapping("/characterList")
    public String showCharacterList(Model character){
        character.addAttribute("characters", characRepository.findAll());
        return "characterList";
    }

    @PostMapping("/add")
    public String addCharacter(@RequestParam String first, @RequestParam String last, @RequestParam Role role, @RequestParam Sex sex) {
        Charac character = new Charac();
        character.setFirstName(first);
        character.setLastName(last);
        character.setRole(role);
        character.setSex(sex);
        characRepository.save(character);
        return "Added new character to repo!";
    }

    @GetMapping("/list")
    public List<Charac> getCharacters() {return (List<Charac>) characRepository.findAll();
    }


    @GetMapping("/{id}")
    public Charac findCharacterById(@PathVariable Integer id) {
        return characRepository.findCharacById(id);
    }

    /**
     * find all characters with the same mother id
     ***/
    @GetMapping("/{id}/children")
    public Set<Charac> getChildren(@PathVariable Integer id) {
        if (
                findCharacterById(id).getSex() == Sex.FEMALE
        ) {
            return characRepository.findCharacsByMother(characRepository.findCharacById(id));
        } else if (
                findCharacterById(id).getSex() == Sex.MALE
        ) {
            return characRepository.findCharacsByFather(characRepository.findCharacById(id));
        }else {
            return null;
        }

    }

}
