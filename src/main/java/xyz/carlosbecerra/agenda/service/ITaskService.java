package xyz.carlosbecerra.agenda.service;

import java.util.Collection;

import xyz.carlosbecerra.agenda.entity.Task;

public interface ITaskService {

	Collection<Task> findAll();

	Task findById(Long taskId);

	void insert(Task task);

	void update(Task task);

	void deleteById(Long taskId);

}
