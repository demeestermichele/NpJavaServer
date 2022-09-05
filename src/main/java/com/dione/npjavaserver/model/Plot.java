package com.dione.npjavaserver.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
    @ManyToMany(mappedBy = "plotSet") //this model maps the chapters
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonBackReference
    private Set<Chapter> chapterSet = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "chapterSet", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonBackReference
    private Set<Charac> characterSet = new LinkedHashSet<>();


    public Plot() {
    }

    public Plot(Integer id, String name, String description, float revision) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.revision = revision;
    }

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

    public Set<Charac> getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(Set<Charac> characterSet) {
        this.characterSet = characterSet;
    }
}
