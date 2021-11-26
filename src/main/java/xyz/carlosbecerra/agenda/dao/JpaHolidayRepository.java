package xyz.carlosbecerra.agenda.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.carlosbecerra.agenda.entity.Holiday;

public interface JpaHolidayRepository extends JpaRepository<Holiday, Long> {

	Collection<Holiday> findByDayAndMonth(Byte day, Byte month);
}
