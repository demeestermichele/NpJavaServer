package com.dione.npjavaserver.repository;

import com.dione.npjavaserver.model.Charac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CharacRepository extends JpaRepository<Charac, Long> {
    //    public Charac findCharacterById(Integer id);
//    public Charac findCharactersByFirstName(String firstName);
//    public Charac findCharactersByLastName(String lastName);
//    public Set<Charac> findCharacsBySex(Sex sex);
//    public Charac findCharacBySex(Sex sex);
//    Set<Charac> getCharacByMother_Id(Long id);
//    Set<Charac> getCharacByFather_Id(Long id);
//    public List<Character> findCharactersByMotherOrFather(Charac mother, Charac father);

}
