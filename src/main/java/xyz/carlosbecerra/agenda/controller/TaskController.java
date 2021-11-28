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
import xyz.carlosbecerra.agenda.entity.Task;
import xyz.carlosbecerra.agenda.service.ITaskService;

@SessionAttributes(names = { "task", "title" })
@Controller
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

	private ITaskService taskService;

	@GetMapping
	public String listar_GET(Model model) {
		model.addAttribute("title", "Tasks");
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("task", new Task());

		return "task/crud";
	}

	@PostMapping("/form")
	public String save_POST(Task task, SessionStatus status) {
		taskService.insert(task);
		status.setComplete();
		System.out.println("Saved");

		return "redirect:";
	}

	@GetMapping("/{taskId}")
	public String buscar_GET(@PathVariable @Positive Long taskId, Model model) {
		Task task = null;

		task = taskService.findById(taskId);
		model.addAttribute("task", task);
		model.addAttribute("tasks", taskService.findAll());
		System.out.println("object: " + task.toString());

		return "task/crud";
	}

	@GetMapping("/delete/{taskId}")
	public String delete_GET(@PathVariable @Positive Long taskId, Model model) {

		try {
			taskService.deleteById(taskId);
			System.out.println("Deleted");
		} catch (Exception e) {
			System.out.println("Don't Delete");
		}

		model.addAttribute("task", new Task());
		model.addAttribute("tasks", taskService.findAll());

		return "task/crud";
	}

}
