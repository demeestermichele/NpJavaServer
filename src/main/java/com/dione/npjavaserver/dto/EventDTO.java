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
    private Long years;
    private Long months;
    private Long days;

    public EventDTO() {
    }

    public EventDTO(String name, EventType type, String location, String description) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.description = description;
    }

    public EventDTO(Long id, String name, EventType type, String location, String description, Long years, Long months, Long days) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.description = description;
        this.years = years;
        this.months = months;
        this.days = days;
    }


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

    public void setYears(Long years) {
        this.years = years;
    }

    public Long getMonths() {
        return months;
    }

    public void setMonths(Long months) {
        this.months = months;
    }

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
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
                Objects.equals(this.years, entity.years) &&
                Objects.equals(this.months, entity.months) &&
                Objects.equals(this.days, entity.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, location, description, years, months, days);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "type = " + type + ", " +
                "location = " + location + ", " +
                "description = " + description + ", " +
                "year = " + years + ", " +
                "month = " + months + ", " +
                "day = " + days + ")";
    }
}
