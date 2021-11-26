package xyz.carlosbecerra.agenda.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.carlosbecerra.agenda.entity.Birthday;

public interface JpaBirthdayRepository extends JpaRepository<Birthday, Long> {

	Collection<Birthday> findByDayAndMonth(Byte day, Byte month);
}
