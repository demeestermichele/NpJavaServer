package com.dione.npjavaserver.calendar.controller;

import com.dione.npjavaserver.calendar.model.Calendar;
import com.dione.npjavaserver.calendar.model.CalendarCalculation;
import com.dione.npjavaserver.calendar.repository.CalendarCalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

@RestController
@RequestMapping("/calender/calculation")
@CrossOrigin(origins = "*")
public class CalendarCalculationController {

    @Autowired
    private CalendarCalculationRepository repository;

    @GetMapping("/list")
    public Set<CalendarCalculation> getAll(List<CalendarCalculation> calculation) {
        return (Set<CalendarCalculation>) repository.findAll();
    }


    @PostMapping("/add")
    public String addCalculation(@RequestParam String name, @RequestParam String description, @RequestParam Calendar calendar1, @RequestParam Calendar calendar2) throws Exception {
        CalendarCalculation calculation = new CalendarCalculation();
        Scanner keyboard = new Scanner(System.in);

        calculation.setCalendar1(calendar1);
        calculation.setCalendar2(calendar2);
        try {
            if (calculation.getCalendar1().getYears() <= 1) {
                calculation.setYearConversion(
                        calendar1.getYears() / calendar2.getYears());
            } else if (calculation.getCalendar1().getYears() > 1) {
                calculation.setYearConversion(calendar2.getYears() / calendar1.getYears());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Calculations added";
    }
}
