package com.dione.npjavaserver.dto;

import com.dione.npjavaserver.model.Charac;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Charac} entity
 */
public class GenealogyDto implements Serializable {
    private final Charac mother;
    private final Charac father;

    public GenealogyDto(CharacDto mother, CharacDto father) {
        this.mother = mother;
        this.father = father;
    }

    public Charac getMother() {
        return mother;
    }

    public Charac getFather() {
        return father;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenealogyDto entity = (GenealogyDto) o;
        return Objects.equals(this.mother, entity.mother) &&
                Objects.equals(this.father, entity.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "mother = " + mother + ", " +
                "father = " + father + ")";
    }
}
