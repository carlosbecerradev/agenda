package xyz.carlosbecerra.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.carlosbecerra.agenda.entity.Activity;

public interface JpaActivityRepository extends JpaRepository<Activity, Long> {

}
