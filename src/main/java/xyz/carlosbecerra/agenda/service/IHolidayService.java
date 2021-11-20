package xyz.carlosbecerra.agenda.service;

import java.util.Collection;

import xyz.carlosbecerra.agenda.entity.Holiday;

public interface IHolidayService {

	Collection<Holiday> findAll();

	Holiday findById(Long holidayId);

	void insert(Holiday holiday);

	void update(Holiday holiday);

	void deleteById(Long holidayId);

}
