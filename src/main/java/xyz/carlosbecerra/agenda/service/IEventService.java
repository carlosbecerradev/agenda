package xyz.carlosbecerra.agenda.service;

import java.time.LocalDate;
import java.util.Collection;

import xyz.carlosbecerra.agenda.entity.Event;

public interface IEventService {

	Collection<Event> findAll();

	Event findById(Long eventId);

	void insert(Event event);

	void update(Event event);

	void deleteById(Long eventId);

	Collection<Event> findByStartDate(LocalDate startDate);

}
