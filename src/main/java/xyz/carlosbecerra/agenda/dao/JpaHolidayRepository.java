package xyz.carlosbecerra.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.carlosbecerra.agenda.entity.Holiday;

public interface JpaHolidayRepository extends JpaRepository<Holiday, Long> {

}
