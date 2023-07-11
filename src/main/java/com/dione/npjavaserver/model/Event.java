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
@Table(name = "Events")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private EventType type;
    private String location;
    private String description;

    private Double short_form;
    private Long years;
    private Long months;
    private Long days;

    /**
     * A Character can have multiple plots, chapters, etc..
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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getYears() {
        return years;
    }

    public void setYears(Long year) {
        this.years = year;
    }

    public Long getMonths() {
        return months;
    }

    public void setMonths(Long month) {
        this.months = month;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long day) {
        this.days = day;
    }

    public Set<Charac> getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(Set<Charac> characterSet) {
        this.characterSet = characterSet;
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

    public Double getShort_form() {
        return short_form;
    }

    public void setShort_form(Double short_form) {
        this.short_form = short_form;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", year=" + years +
                ", month=" + months +
                ", day=" + days +
                ", characterSet=" + characterSet +
                ", chapterSet=" + chapterSet +
                ", plotSet=" + plotSet +
                '}';
    }
}
