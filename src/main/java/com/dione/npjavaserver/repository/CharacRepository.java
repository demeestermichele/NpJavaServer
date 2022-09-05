package com.dione.npjavaserver.repository;

import com.dione.npjavaserver.model.Charac;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CharacRepository extends CrudRepository<Charac, Integer> {
    public Charac findCharacById(Integer id);
    public Charac findCharactersByFirstName(String firstName);
    public Charac findCharactersByLastName(String lastName);
    public Set<Charac> findCharacsByMother(Charac mother);
    public Set<Charac> findCharacsByFather(Charac father);
//    public List<Character> findCharactersByMotherOrFather(Charac mother, Charac father);

}
