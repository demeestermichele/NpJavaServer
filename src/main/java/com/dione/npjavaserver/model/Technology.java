package com.dione.npjavaserver.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "technology")
public class Technology implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String description;

    //TODO list of worlds, cultures?, Planets

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
