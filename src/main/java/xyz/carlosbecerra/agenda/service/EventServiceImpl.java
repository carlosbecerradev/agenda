package xyz.carlosbecerra.agenda.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.carlosbecerra.agenda.dao.JpaEventRepository;
import xyz.carlosbecerra.agenda.entity.Event;

@Service
@AllArgsConstructor
public class EventServiceImpl implements IEventService {

	private final JpaEventRepository eventRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Event findById(Long eventId) {
		return eventRepository.findById(eventId).orElse(new Event());
	}

	@Override
	@Transactional
	public void insert(Event event) {
		eventRepository.save(event);
	}

	@Override
	@Transactional
	public void update(Event event) {
		eventRepository.save(event);
	}

	@Override
	@Transactional
	public void deleteById(Long eventId) {
		eventRepository.deleteById(eventId);
	}

}
