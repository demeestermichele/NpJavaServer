package com.dione.npjavaserver.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "World")
public class World implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String description;

    private String terrain;

    @OneToMany(mappedBy = "world")
    private Set<Planet> planets = new LinkedHashSet<>();
    //TODO list cultures, planets, technologies, characters, chapters

    //TODO
    @ManyToMany
    private Set<Technology> technology = new LinkedHashSet<>();

}
