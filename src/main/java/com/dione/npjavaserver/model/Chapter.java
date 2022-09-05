/**Chapter model by demeestermichele**/
package com.dione.npjavaserver.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Chapter")
public class Chapter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer number;

    private float version;

    private String description;


    /**
     * A chapter can have multiple plots, characters, etc..
     * When in danger of recursion choose to display ID of Mapping
     **/
    @ManyToMany(mappedBy = "chapterSet", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonBackReference
    private Set<Charac> characterSet = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.ALL) //this model maps the chapters
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JoinTable(name = "chapter_plots",joinColumns = @JoinColumn(name = "chapter_id"),
            inverseJoinColumns = @JoinColumn(name = "plot_id"))
    @JsonManagedReference
    private Set<Plot> plotSet = new LinkedHashSet<>();



    /**Constructors**/
    public Chapter() {
    }

    public Chapter(Integer id) {
        this.id = id;
    }

    public Chapter(Integer id, String name, Integer number, float version, String description) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.version = version;
        this.description = description;
    }

    /**Getters and Setters**/
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

    public Set<Charac> getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(Set<Charac> characterSet) {
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
