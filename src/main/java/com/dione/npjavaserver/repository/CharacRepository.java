package com.dione.npjavaserver.repository;

import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.model.Sex;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CharacRepository extends CrudRepository<Charac, Integer> {
    public Charac findCharacById(Integer id);
    public Charac findCharactersByFirstName(String firstName);
    public Charac findCharactersByLastName(String lastName);
    public Set<Charac> findCharacsBySex(Sex sex);
    public Charac findCharacBySex(Sex sex);
    public Set<Charac> findCharacsByMother(Charac mother);
    public Set<Charac> findCharacsByFather(Charac father);
//    public List<Character> findCharactersByMotherOrFather(Charac mother, Charac father);

}
