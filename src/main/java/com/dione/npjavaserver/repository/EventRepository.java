package com.dione.npjavaserver.repository;

import com.dione.npjavaserver.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
