package xyz.carlosbecerra.agenda.dao;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import xyz.carlosbecerra.agenda.entity.Event;

public interface JpaEventRepository extends JpaRepository<Event, Long> {

	@Query("SELECT e FROM Event e where e.startDatetime BETWEEN :startDatetime AND :endDatetime")
	Collection<Event> findBetweenStartDatetimeAndEndDatetime(@Param("startDatetime") LocalDateTime startDatetime,
			@Param("endDatetime") LocalDateTime endDatetime);

}
