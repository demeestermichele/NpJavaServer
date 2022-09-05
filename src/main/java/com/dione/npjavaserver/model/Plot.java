package com.dione.npjavaserver.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Plot")
public class Plot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private float revision;


    /**
     * A plot can have multiple characters, chapters, etc..
     * When in danger of recursion choose to display ID of Mapping
     **/
    @ManyToMany(mappedBy = "plot") //this model maps the chapters
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIgnore
    private Set<Chapter> chapterSet = new HashSet<>();

    @ManyToMany(mappedBy = "plot") //this model maps the chapters
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIgnore
    private Set<Character> characterSet = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRevision() {
        return revision;
    }

    public void setRevision(float revision) {
        this.revision = revision;
    }

    public Set<Chapter> getChapterSet() {
        return chapterSet;
    }

    public void setChapterSet(Set<Chapter> chapterSet) {
        this.chapterSet = chapterSet;
    }

    public Set<Character> getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(Set<Character> characterSet) {
        this.characterSet = characterSet;
    }
}
