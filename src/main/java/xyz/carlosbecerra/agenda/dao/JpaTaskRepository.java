package xyz.carlosbecerra.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.carlosbecerra.agenda.entity.Task;

public interface JpaTaskRepository extends JpaRepository<Task, Long> {

}
