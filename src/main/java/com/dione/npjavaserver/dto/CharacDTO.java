package com.dione.npjavaserver.dto;

import com.dione.npjavaserver.model.Charac;
import com.dione.npjavaserver.model.Sex;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Charac} entity
 */
public class CharacDTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Sex sex;

    public CharacDTO(Long id, String firstName, String lastName, Sex sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public CharacDTO() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacDTO entity = (CharacDTO) o;
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
