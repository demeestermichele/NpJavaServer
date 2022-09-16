package com.dione.npjavaserver.calendar.repository;

import com.dione.npjavaserver.calendar.model.CalendarCalculation;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CalendarCalculationRepository extends CrudRepository<CalendarCalculation, Double> {
    Set<CalendarCalculation> findAllById(Long id);

//    CalendarCalculation

}
