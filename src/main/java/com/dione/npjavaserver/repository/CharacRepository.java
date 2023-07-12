package com.dione.npjavaserver.repository;

import com.dione.npjavaserver.model.Charac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CharacRepository extends JpaRepository<Charac, Long> {

//    public Charac findCharactersByFirstName(String firstName);
//    public Charac findCharactersByLastName(String lastName);
//    public Set<Charac> findCharacsBySex(Sex sex);
//    public Charac findCharacBySex(Sex sex);

    public List<Character> findCharactersByMother(Charac parent);

    public List<Character> findCharacsByFather(Charac parent);

}
