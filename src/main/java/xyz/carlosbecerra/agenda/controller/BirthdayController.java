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
import xyz.carlosbecerra.agenda.entity.Birthday;
import xyz.carlosbecerra.agenda.service.IBirthdayService;

@SessionAttributes(names = { "birthday", "title" })
@Controller
@RequestMapping("/birthday")
@AllArgsConstructor
public class BirthdayController {

	private IBirthdayService iBirthdayService;

	@GetMapping
	public String listar_GET(Model model) {
		model.addAttribute("title", "Birthday's");
		model.addAttribute("birthdays", iBirthdayService.findALl());
		model.addAttribute("birthday", new Birthday());

		return "birthday/crud";
	}

	@PostMapping("/form")
	public String save_POST(Birthday birthday, SessionStatus status) {
		birthday.setEnabled(true);
		iBirthdayService.insert(birthday);
		status.setComplete();
		System.out.println("Saved");

		return "redirect:";
	}

	@GetMapping("/{birthdayId}")
	public String buscar_GET(@PathVariable @Positive Long birthdayId, Model model) {
		Birthday birthday = null;

		birthday = iBirthdayService.findById(birthdayId);
		model.addAttribute("birthday", birthday);
		model.addAttribute("birthdays", iBirthdayService.findALl());
		System.out.println("object: " + birthday.toString());

		return "birthday/crud";
	}

	@GetMapping("/delete/{birthdayId}")
	public String delete_GET(@PathVariable @Positive Long birthdayId, Model model) {

		try {
			iBirthdayService.deleteById(birthdayId);
			System.out.println("Deleted");
		} catch (Exception e) {
			System.out.println("Don't Delete");
		}

		model.addAttribute("birthday", new Birthday());
		model.addAttribute("birthdays", iBirthdayService.findALl());

		return "birthday/crud";
	}

}
