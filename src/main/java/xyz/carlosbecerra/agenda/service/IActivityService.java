package xyz.carlosbecerra.agenda.service;

import java.util.Collection;

import xyz.carlosbecerra.agenda.entity.Activity;

public interface IActivityService {

	Collection<Activity> findAll();

	Activity findById(Long activityId);

	void insert(Activity activity);

	void update(Activity activity);

	void deleteById(Long activityId);

}
