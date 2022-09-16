package com.dione.npjavaserver.calendar.model;

import javax.persistence.*;

@Entity
public class CalendarCalculation {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "calendar_1_id")
    private Calendar calendar1;
    @ManyToOne
    @JoinColumn(name = "calendar_2_id")
    private Calendar calendar2;

    private Double yearConversion;
    private Double monthConversion;
    private Double weekConversion;
    private Double dayConversion;
    private Double hourConversion;
    private Double minuteConversion;
    private Double secondConversion;


    public CalendarCalculation() {

    }

    public CalendarCalculation(Long id, String name, String description, Calendar calendar1, Calendar calendar2) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.calendar1 = calendar1;
        this.calendar2 = calendar2;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getCalendar2() {
        return calendar2;
    }

    public void setCalendar2(Calendar calendar2) {
        this.calendar2 = calendar2;
    }

    public Calendar getCalendar1() {
        return calendar1;
    }

    public void setCalendar1(Calendar calendar1) {
        this.calendar1 = calendar1;
    }

    public Double getYearConversion() {
        return yearConversion;
    }

    public void setYearConversion(Double yearConversion) {
        this.yearConversion = yearConversion;
    }

    public Double getMonthConversion() {
        return monthConversion;
    }

    public void setMonthConversion(Double monthConversion) {
        this.monthConversion = monthConversion;
    }

    public Double getWeekConversion() {
        return weekConversion;
    }

    public void setWeekConversion(Double weekConversion) {
        this.weekConversion = weekConversion;
    }

    public Double getDayConversion() {
        return dayConversion;
    }

    public void setDayConversion(Double dayConversion) {
        this.dayConversion = dayConversion;
    }

    public Double getHourConversion() {
        return hourConversion;
    }

    public void setHourConversion(Double hourConversion) {
        this.hourConversion = hourConversion;
    }

    public Double getMinuteConversion() {
        return minuteConversion;
    }

    public void setMinuteConversion(Double minuteConversion) {
        this.minuteConversion = minuteConversion;
    }

    public Double getSecondConversion() {
        return secondConversion;
    }

    public void setSecondConversion(Double secondConversion) {
        this.secondConversion = secondConversion;
    }
}
