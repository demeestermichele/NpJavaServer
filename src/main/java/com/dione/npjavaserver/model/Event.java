package com.dione.npjavaserver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "EVENT")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private EventType type;
    private String location;
    private String description;
    private Long year;
    private Long month;
    private Long day;

    /**
     * A Charac can have multiple plots, chapters, etc..
     * When in danger of recursion choose to display ID of Mapping
     **/
    @ManyToMany(mappedBy = "eventSet", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonBackReference
    private Set<Charac> characterSet = new LinkedHashSet<>();

    /**
     * A chapter can have multiple plots, characters, etc..
     * When in danger of recursion choose to display ID of Mapping
     **/
    @ManyToMany(mappedBy = "eventSet", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonBackReference
    private Set<Chapter> chapterSet = new LinkedHashSet<>();


    /**
     * A plot can have multiple events, chapters, characters, etc..
     * When in danger of recursion choose to display ID of Mapping
     **/
    @ManyToMany(mappedBy = "eventSet", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonBackReference
    private Set<Plot> plotSet = new LinkedHashSet<>();



}
