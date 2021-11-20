package xyz.carlosbecerra.agenda.service;

import java.util.Collection;

import xyz.carlosbecerra.agenda.entity.Birthday;

public interface IBirthdayService {

	Collection<Birthday> findALl();

	Birthday findById(Long birthdayId);

	void insert(Birthday birthday);

	void update(Birthday birthday);

	void deleteById(Long birthdayId);

}
