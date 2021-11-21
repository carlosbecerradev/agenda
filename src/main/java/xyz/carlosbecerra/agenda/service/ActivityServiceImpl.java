package xyz.carlosbecerra.agenda.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.carlosbecerra.agenda.dao.JpaActivityRepository;
import xyz.carlosbecerra.agenda.entity.Activity;

@Service
@AllArgsConstructor
public class ActivityServiceImpl implements IActivityService {

	private final JpaActivityRepository activityRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Activity> findAll() {
		return activityRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Activity findById(Long activityId) {
		return activityRepository.findById(activityId).orElse(new Activity());
	}

	@Override
	@Transactional
	public void insert(Activity activity) {
		activityRepository.save(activity);
	}

	@Override
	@Transactional
	public void update(Activity activity) {
		activityRepository.save(activity);
	}

	@Override
	@Transactional
	public void deleteById(Long activityId) {
		activityRepository.deleteById(activityId);
	}

}
