package xyz.carlosbecerra.agenda.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.carlosbecerra.agenda.dao.JpaTaskRepository;
import xyz.carlosbecerra.agenda.entity.Task;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements ITaskService {

	private final JpaTaskRepository taskRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Task findById(Long taskId) {
		return taskRepository.findById(taskId).orElse(new Task());
	}

	@Override
	@Transactional
	public void insert(Task task) {
		taskRepository.save(task);
	}

	@Override
	@Transactional
	public void update(Task task) {
		taskRepository.save(task);
	}

	@Override
	@Transactional
	public void deleteById(Long taskId) {
		taskRepository.deleteById(taskId);
	}

}
