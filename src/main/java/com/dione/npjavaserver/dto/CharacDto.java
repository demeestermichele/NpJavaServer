package com.dione.npjavaserver.dto;

import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.model.Sex;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Charac} entity
 */
public class CharacDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Sex sex;
    private CharacDto father;
    private CharacDto mother;

    public CharacDto(Long id, String firstName, String lastName, Sex sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public CharacDto(Long id, String firstName, String lastName, Sex sex, CharacDto father, CharacDto mother) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.father = father;
        this.mother = mother;
    }

    public CharacDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public CharacDto getFather() {
        return father;
    }

    public void setFather(CharacDto father) {
        this.father = father;
    }

    public CharacDto getMother() {
        return mother;
    }

    public void setMother(CharacDto mother) {
        this.mother = mother;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacDto entity = (CharacDto) o;
        return Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.sex, entity.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, sex);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "sex = " + sex + ")";
    }



}
