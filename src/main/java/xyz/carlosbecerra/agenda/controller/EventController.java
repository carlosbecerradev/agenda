package xyz.carlosbecerra.agenda.controller;

import javax.validation.constraints.Positive;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.AllArgsConstructor;
import xyz.carlosbecerra.agenda.entity.Event;
import xyz.carlosbecerra.agenda.service.IEventService;

@SessionAttributes(names = { "event", "title" })
@Controller
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {

	private IEventService eventService;

	@GetMapping
	public String listar_GET(Model model) {
		model.addAttribute("title", "Events");
		model.addAttribute("events", eventService.findAll());
		model.addAttribute("event", new Event());

		return "event/crud";
	}

	@PostMapping("/form")
	public String save_POST(Event event, SessionStatus status) {

		event.setEnabled(true);
		System.out.println("INFO: " + event.toString());

		eventService.insert(event);
		status.setComplete();
		System.out.println("Saved");

		return "redirect:";
	}

	@GetMapping("/{eventId}")
	public String buscar_GET(@PathVariable @Positive Long eventId, Model model) {
		Event event = null;

		event = eventService.findById(eventId);
		model.addAttribute("event", event);
		model.addAttribute("events", eventService.findAll());
		System.out.println("object: " + event.toString());

		return "event/crud";
	}

	@GetMapping("/delete/{eventId}")
	public String delete_GET(@PathVariable @Positive Long eventId, Model model) {

		try {
			eventService.deleteById(eventId);
			System.out.println("Deleted");
		} catch (Exception e) {
			System.out.println("Don't Delete");
		}

		model.addAttribute("event", new Event());
		model.addAttribute("events", eventService.findAll());

		return "event/crud";
	}
}
