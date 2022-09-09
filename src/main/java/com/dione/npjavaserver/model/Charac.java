package com.dione.npjavaserver.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Character")
public class Charac implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private Sex sex;
    private Role role;


    /**
     * One mother (character.Sex == FEMALE) can have multiple children
     **/
    //TODO make a difference between biological and effective parent
    @ManyToOne
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonManagedReference
    @JoinColumn(name = "mother", nullable = true)
    private Charac mother;

    /**
     * One father (character.Sex == MALE) can have many children
     **/
    //TODO make a difference between biological and effective parent
    @ManyToOne
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonManagedReference
    @JoinColumn(name = "father", nullable = true)
    private Charac father;


    /**
     * A character can be in multiple plots, chapters, etc..
     * When in danger of recursion choose to display ID
     **/

    @ManyToMany(cascade = CascadeType.ALL) //this model maps the chapters
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonManagedReference
    @JoinTable(name = "characters_chapters", joinColumns = @JoinColumn(name = "charac_id"),
            inverseJoinColumns = @JoinColumn(name = "chapter_id"))
    private Set<Chapter> chapterSet = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.ALL) //this model maps the chapters
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonManagedReference
    @JoinTable(name = "characters_plots", joinColumns = @JoinColumn(name = "charac_id"),
            inverseJoinColumns = @JoinColumn(name = "plot_id"))
    private Set<Plot> plotSet = new LinkedHashSet<>();

    /**
     * Constructors
     **/
    public Charac() {
    }

    public Charac(Integer id) {
        this.id = id;
    }

    public Charac(String firstName) {
        this.firstName = firstName;
    }

    public Charac(String firstName, String lastName, Sex sex, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.role = role;
    }

    public Charac(Integer id, String firstName, String lastName, Sex sex, Role role, Charac mother, Charac father) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.role = role;
        this.mother = mother;
        this.father = father;
    }

    /**
     * Getters and setters
     **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Charac getMother() {
        return mother;
    }

    public void setMother(Charac mother) {
        this.mother = mother;
    }

    public Charac getFather() {
        return father;
    }

    public void setFather(Charac father) {
        this.father = father;
    }

    public Set<Chapter> getChapterSet() {
        return chapterSet;
    }

    public void setChapterSet(Set<Chapter> chapterSet) {
        this.chapterSet = chapterSet;
    }

    public Set<Plot> getPlotSet() {
        return plotSet;
    }

    public void setPlotSet(Set<Plot> plotSet) {
        this.plotSet = plotSet;
    }

    /**
     * ToString
     **/
    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", role=" + role +
                ", mother=" + mother +
                ", father=" + father +
                '}';
    }
}
