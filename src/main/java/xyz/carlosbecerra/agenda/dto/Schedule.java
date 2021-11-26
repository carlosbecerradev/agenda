package xyz.carlosbecerra.agenda.dto;

import java.time.LocalDate;
import java.util.Collection;

import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.carlosbecerra.agenda.entity.Birthday;
import xyz.carlosbecerra.agenda.entity.Event;
import xyz.carlosbecerra.agenda.entity.Holiday;

@Data
@NoArgsConstructor
public class Schedule {

	private LocalDate date;
	private String titleDate;
	private Collection<Event> events;
	private Collection<Birthday> birthdays;
	private Collection<Holiday> holidays;

	public Schedule(LocalDate date, String titleDate, Collection<Event> events, Collection<Birthday> birthdays,
			Collection<Holiday> holidays) {
		super();
		this.date = date;
		this.titleDate = convertDateToTitleDate(date);
		this.events = events;
		this.birthdays = birthdays;
		this.holidays = holidays;
	}

	private String convertDateToTitleDate(LocalDate date) {
		return date.getMonth() + " " + date.getDayOfMonth() + " Of " + date.getYear();
	}

}
