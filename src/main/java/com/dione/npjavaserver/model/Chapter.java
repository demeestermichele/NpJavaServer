/**Chapter model by demeestermichele**/
package com.dione.npjavaserver.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Chapter")
public class Chapter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer number;

    private float version;

    private String description;


    /**
     * A chapter can have multiple plots, characters, etc..
     * When in danger of recursion choose to display ID of Mapping
     **/
    @ManyToMany(mappedBy = "chapter")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIgnore
    private Set<Character> characterSet = new HashSet<>();

    @ManyToMany(mappedBy = "chapter")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIgnore
    private Set<Plot> plotSet = new HashSet<>();



    /**Constructors**/
    public Chapter() {
    }

    public Chapter(Long id) {
        this.id = id;
    }

    public Chapter(Long id, String name, Integer number, float version, String description, List<Character> charactersList) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.version = version;
        this.description = description;
    }

    /**Getters and Setters**/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Character> getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(Set<Character> characterSet) {
        this.characterSet = characterSet;
    }

    public Set<Plot> getPlotSet() {
        return plotSet;
    }

    public void setPlotSet(Set<Plot> plotSet) {
        this.plotSet = plotSet;
    }

    /**To String**/
    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", version=" + version +
                ", description='" + description + '\'' +
                '}';
    }
}
