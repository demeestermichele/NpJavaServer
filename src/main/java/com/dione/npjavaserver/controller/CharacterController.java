package com.dione.npjavaserver.controller;

import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.model.Role;
import com.dione.npjavaserver.model.Sex;
import com.dione.npjavaserver.repository.CharacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
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
    public String showCharacterList(Model character) {
        character.addAttribute("characters", characRepository.findAll());
        return characRepository.findAll().toString();
    }

    @PostMapping("/add")
    public String addCharacter(@RequestParam String first, @RequestParam String last, @RequestParam Role role, @RequestParam Sex sex, @RequestParam Charac mother, @RequestParam Charac father) throws Exception {
        Charac character = new Charac();
        character.setFirstName(first);
        character.setLastName(last);
        try {
            //do this in client
            // String role1 = role.toString().toUpperCase();
            character.setRole(role);
        } catch (ConversionFailedException e) {
            System.err.println("Role needs to be in capitals" + e);
        }
        //TODO add gender
        try {
            character.setSex(sex);
        } catch (Exception e) {
            System.err.println("error " + e);
            throw new Exception();
        }

        //TODO well this isn't very PC. add "legal guardians"

        if (mother.getSex() == Sex.FEMALE) {
            character.setMother(mother);
        } else {
            throw new Exception("Character with id= " + mother.getId() + " is not female");
        }


        if (father.getSex() == Sex.MALE) {
            character.setFather(father);
        } else {
            throw new Exception("Character with id= " + father.getId() + " is not male");
        }
        characRepository.save(character);
        return "Added new character to repo!";
    }

    @PostMapping("/patch")
    public String patchCharacter(@RequestParam Integer id, @RequestParam String first, @RequestParam String last, @RequestParam Role role, @RequestParam Sex sex, @RequestParam Charac mother, @RequestParam Charac father) throws Exception {
        Charac character = findCharacterById(id);
        if (character == null) {
            character = new Charac();
            this.addCharacter(first, last, role, sex, mother, father);
        } else {
            if (character.getFirstName() != null) {
                character.setFirstName(first);
            }
            if (character.getLastName() != null) {
                character.setLastName(last);
            }
            if (character.getRole() != null) {
                try {
                    //do this in client
                    // String role1 = role.toString().toUpperCase();
                    character.setRole(role);
                } catch (ConversionFailedException e) {
                    System.err.println(e);
                }
            }
            if (character.getSex() != null) {
                try {
                    character.setSex(sex);
                } catch (Exception e) {
                    System.err.println("error " + e);
                    throw new Exception();
                }
            }
            if (character.getMother() != null) {
                if (mother.getSex() == Sex.FEMALE) {
                    character.setMother(mother);
                } else {
                    throw new Exception(mother.getId() + " is not female");
                }
            }
            if (character.getFather() != null) {
                if (father.getSex() == Sex.MALE) {
                    character.setFather(father);
                } else {
                    throw new Exception(father.getId() + " is not male");
                }
            }
        }
        characRepository.save(character);
        return "Character updated";

    }

    @GetMapping("/list")
    public List<Charac> getCharacters() {
        return (List<Charac>) characRepository.findAll();
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
        if (findCharacterById(id).getSex() == Sex.FEMALE) {
            return characRepository.findCharacsByMother(characRepository.findCharacById(id));
        } else if (findCharacterById(id).getSex() == Sex.MALE) {
            return characRepository.findCharacsByFather(characRepository.findCharacById(id));
        } else {
            return null;
        }

    }

}
