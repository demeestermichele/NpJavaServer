/*
package com.dione.npjavaserver.calendar.controller;

import com.dione.npjavaserver.calendar.model.Calendar;
import com.dione.npjavaserver.calendar.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/calendar")
@CrossOrigin(origins = "*")
public class CalendarController {

    @Autowired
    //FIXME calendarRepository is NULL
    private CalendarRepository calendarRepository;

    @PostMapping(value = "/add")
    public String addCalendar(@RequestParam String name, @RequestParam String description, @RequestParam Double years, @RequestParam Double months, @RequestParam Double weeks, @RequestParam Double days, @RequestParam Double hours, @RequestParam Double minutes, @RequestParam Double seconds) throws Exception {
        Calendar calendar = new Calendar();
        calendar.setName(name);
        calendar.setDescription(description);
        try {
            calendar.setYears(years);
        } catch (Exception e) {
            System.err.println("error " + e);
            throw new Exception();
        }
        try {
            calendar.setMonths(months);
        } catch (Exception e) {
            System.err.println("error " + e);
            throw new Exception();
        }
        try {
            calendar.setWeeks(weeks);
        } catch (Exception e) {
            System.err.println("error " + e);
            throw new Exception();
        }
        try {
            calendar.setWeeks(weeks);
        } catch (Exception e) {
            System.err.println("error " + e);
            throw new Exception();
        }
        try {
            calendar.setDays(days);
        } catch (Exception e) {
            System.err.println("error " + e);
            throw new Exception();
        }
        try {
            calendar.setHours(hours);
        } catch (Exception e) {
            System.err.println("error " + e);
            throw new Exception();
        }
        try {
            calendar.setMinutes(minutes);
        } catch (Exception e) {
            System.err.println("error " + e);
            throw new Exception();
        }
        try {
            calendar.setSeconds(seconds);
        } catch (Exception e) {
            System.err.println("error " + e);
            throw new Exception();
        }
        calendarRepository.save(calendar);
        return "Calendar added";
    }

    @GetMapping("/calendarList")
    public String getAllCalendars(Model calendar) {
        calendar.addAttribute("calendars", calendarRepository.findAll());
        return calendarRepository.findAll().toString();
    }

    @GetMapping("/list")
    public Set<Calendar> getCharacters() {
        return (Set<Calendar>) calendarRepository.findAll();
    }


    @GetMapping("/{id}")
    public Calendar findCharacterById(@PathVariable Long id) {
        return calendarRepository.findCalendarById(id);
    }

}
*/
