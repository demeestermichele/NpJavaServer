package com.dione.npjavaserver.dto;

import com.dione.npjavaserver.model.Event;
import com.dione.npjavaserver.model.EventType;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Event} entity
 */
public class EventDTO implements Serializable {
    private Long id;
    private String name;
    private EventType type;
    private String location;
    private String description;
    private Long year;
    private Long month;
    private Long day;

    public EventDTO() {
    }

    public EventDTO(Long id, String name, EventType type, String location, String description, Long year, Long month, Long day) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.description = description;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EventType getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Long getYear() {
        return year;
    }

    public Long getMonth() {
        return month;
    }

    public Long getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDTO entity = (EventDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.type, entity.type) &&
                Objects.equals(this.location, entity.location) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.year, entity.year) &&
                Objects.equals(this.month, entity.month) &&
                Objects.equals(this.day, entity.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, location, description, year, month, day);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "type = " + type + ", " +
                "location = " + location + ", " +
                "description = " + description + ", " +
                "year = " + year + ", " +
                "month = " + month + ", " +
                "day = " + day + ")";
    }
}
