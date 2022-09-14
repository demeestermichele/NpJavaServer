package com.dione.npjavaserver.controller;

import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.model.Role;
import com.dione.npjavaserver.model.Sex;
import com.dione.npjavaserver.repository.CharacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
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

    /**
     * Add new character to table "character"
     *
     * @param first  String first name of the character.
     * @param last   String last name of the character.
     * @param role   Enumeration what role does the character play in the story options: PROTAGONIST, ANTAGONIST, SIDE, BACKGROUND, THROWAWAY
     * @param sex    Enumeration what is the sex of the character, options: MALE, FEMALE, THERIAN (shape-shifter)
     * @param mother Character the biological mother of the character, input the ID of the mother
     * @param father Character the biological father of the character, input the ID of the father
     * @return verification message.
     * @throws Exception for try-catch
     */
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

        if (mother.getSex() != Sex.MALE) {
            try {
                character.setMother(mother);
            } catch (Exception e) {
                throw new Exception(mother.getFirstName() + " is male and cannot be the biological mother");
            }
        }

        if (father.getSex() != Sex.FEMALE) {
            try {
                character.setFather(father);

            } catch (Exception e) {
                throw new Exception(father.getFirstName() + " is female and cannot be the biological father.");
            }

        }
        characRepository.save(character);
        return "Added new character to repo!";
    }

    /**
     * Patch works using PostMapping. Will automatically create new character in the event that the intended character doesn't exist.
     *
     * @param id     Integer id of the character, this is only a search parameter and not post, ids are autogenerated.
     * @param first  String first name of the character.
     * @param last   String last name of the character.
     * @param role   Enumeration what role does the character play in the story options: PROTAGONIST, ANTAGONIST, SIDE, BACKGROUND, THROWAWAY
     * @param sex    Enumeration what is the sex of the character, options: MALE, FEMALE, THERIAN (shape-shifter)
     * @param mother Character the biological mother of the character, input the ID of the mother
     * @param father Character the biological father of the character, input the ID of the father
     * @return String to verify that patch worked
     * @throws Exception for try-catch, so the program doesn't crash all the time
     */
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
                    System.err.println("unable to set role");
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
                if (mother.getSex() != Sex.MALE) {
                    try {
                        character.setMother(mother);

                    } catch (Exception e) {
                        throw new Exception(mother.getFirstName() + " is male.");
                    }
                }
                if (character.getFather() != null) {
                    if (father.getSex() != Sex.FEMALE) {
                        try {
                            character.setFather(father);
                        } catch (Exception e) {
                            throw new Exception(father.getFirstName() + " is female");
                        }
                    }
                }
            }
        }
        characRepository.save(character);
        return "Character updated";
    }

    /**
     * GET list of all objects in table "character"
     *
     * @return json list of characters
     */
    @GetMapping("/list")
    public List<Charac> getCharacters() {
        return (List<Charac>) characRepository.findAll();
    }


    @GetMapping("/{id}")
    public Charac findCharacterById(@PathVariable Integer id) {
        return characRepository.findCharacById(id);
    }

    /**
     * find all characters with the same parent id
     * @param id of the character whose kids we want to find
     * @return
     */
    @GetMapping("/{id}/children")
    public Set<Charac> getChildren(@PathVariable Integer id) {
        if (findCharacterById(id).getSex() == Sex.FEMALE) {
            return characRepository.findCharacsByMother(characRepository.findCharacById(id));
        } else if (findCharacterById(id).getSex() == Sex.MALE) {
            return characRepository.findCharacsByFather(characRepository.findCharacById(id));
        }else if( findCharacterById(id).getSex() == Sex.THERIAN){
            Set<Charac> charSex = characRepository.findCharacsByFather(characRepository.findCharacById(id));
            charSex.addAll(characRepository.findCharacsByMother(characRepository.findCharacById(id)));
            return charSex;
        } else {
            return null;
        }

    }

}
