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
import xyz.carlosbecerra.agenda.entity.Holiday;
import xyz.carlosbecerra.agenda.service.IHolidayService;

@SessionAttributes(names = {
		"holiday", "title" })
@Controller
@RequestMapping("/holiday")
@AllArgsConstructor
public class HolidayController {

	private IHolidayService holidayService;

	@GetMapping
	public String listar_GET(Model model) {
		model.addAttribute("title", "Holidays");
		model.addAttribute("holidays", holidayService.findAll());
		model.addAttribute("holiday", new Holiday());

		return "holiday/crud";
	}

	@PostMapping("/form")
	public String save_POST(Holiday holiday, SessionStatus status) {
		holiday.setEnabled(true);
		holidayService.insert(holiday);
		status.setComplete();
		System.out.println("Saved");

		return "redirect:";
	}

	@GetMapping("/{holidayId}")
	public String buscar_GET(@PathVariable @Positive Long holidayId, Model model) {
		Holiday holiday = null;

		holiday = holidayService.findById(holidayId);
		model.addAttribute("holiday", holiday);
		model.addAttribute("holidays", holidayService.findAll());
		System.out.println("object: " + holiday.toString());

		return "holiday/crud";
	}

	@GetMapping("/delete/{holidayId}")
	public String delete_GET(@PathVariable @Positive Long holidayId, Model model) {

		try {
			holidayService.deleteById(holidayId);
			System.out.println("Deleted");
		} catch (Exception e) {
			System.out.println("Don't Delete");
		}

		model.addAttribute("holiday", new Holiday());
		model.addAttribute("holidays", holidayService.findAll());

		return "holiday/crud";
	}

}
