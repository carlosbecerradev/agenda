package xyz.carlosbecerra.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.carlosbecerra.agenda.entity.Event;

public interface JpaEventRepository extends JpaRepository<Event, Long> {

}
