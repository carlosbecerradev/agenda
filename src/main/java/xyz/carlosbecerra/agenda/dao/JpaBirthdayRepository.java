package xyz.carlosbecerra.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.carlosbecerra.agenda.entity.Birthday;

public interface JpaBirthdayRepository extends JpaRepository<Birthday, Long> {

}
