package xyz.carlosbecerra.agenda.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.AllArgsConstructor;
import xyz.carlosbecerra.agenda.dto.Schedule;
import xyz.carlosbecerra.agenda.entity.Birthday;
import xyz.carlosbecerra.agenda.entity.Event;
import xyz.carlosbecerra.agenda.entity.Holiday;
import xyz.carlosbecerra.agenda.service.IBirthdayService;
import xyz.carlosbecerra.agenda.service.IEventService;
import xyz.carlosbecerra.agenda.service.IHolidayService;

@SessionAttributes(names = { "title" })
@Controller
@AllArgsConstructor
public class IndexController {

	private final IBirthdayService birthdayService;
	private final IHolidayService holidayService;
	private final IEventService eventService;

	@GetMapping
	public String index_GET(Model model,
			@RequestParam(name = "startDate", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate startDate,
			@RequestParam(name = "endDate", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate endDate) {

		Collection<Schedule> schedules = new ArrayList<>();
		Collection<Event> events = new ArrayList<>();
		Collection<Birthday> birthdays = new ArrayList<>();
		Collection<Holiday> holidays = new ArrayList<>();

		if (startDate == null) {
			startDate = LocalDate.now();
		}

		if (endDate == null) {
			endDate = startDate;
		}

		int countDays = (int) startDate.until(endDate, ChronoUnit.DAYS);
		LocalDate date = startDate;

		if (countDays >= 0) {
			for (int i = 0; i <= countDays; i++) {

				events = eventService.findByStartDate(date);
				birthdays = birthdayService.findByStartDate(date);
				holidays = holidayService.findByStartDate(date);

				if (events.isEmpty() && birthdays.isEmpty() && holidays.isEmpty()) {
					date = date.plusDays(1);
					continue;
				}

				Schedule daySchedule = new Schedule(date, "", events, birthdays, holidays);
				schedules.add(daySchedule);

				date = date.plusDays(1);
			}
		}

		model.addAttribute("title", "Agenda");
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("schedules", schedules);

		return "index";
	}

}
