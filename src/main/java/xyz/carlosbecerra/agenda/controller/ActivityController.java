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
import xyz.carlosbecerra.agenda.entity.Activity;
import xyz.carlosbecerra.agenda.service.IActivityService;
import xyz.carlosbecerra.agenda.service.ITaskService;

@SessionAttributes(names = { "activity", "title" })
@Controller
@RequestMapping("/activity")
@AllArgsConstructor
public class ActivityController {

	private final IActivityService activityService;
	private final ITaskService taskService;

	@GetMapping
	public String list_GET(Model model) {
		model.addAttribute("title", "Activities");
		model.addAttribute("activity", new Activity());
		model.addAttribute("activities", activityService.findAll());
		model.addAttribute("tasks", taskService.findAll());

		return "activity/crud";
	}

	@PostMapping("/form")
	public String save_POST(Activity activity, Model model, SessionStatus status) {

		activityService.insert(activity);
		status.setComplete();
		System.out.println("Saved");

		return "redirect:";
	}

	@GetMapping("/{activityId}")
	public String find_GET(@PathVariable @Positive Long activityId, Model model) {
		Activity activity = null;

		activity = activityService.findById(activityId);
		if (activity.getActivityId() != null) {
			activity.getTask().setActivities(null);
		}
		model.addAttribute("activity", activity);

		model.addAttribute("activities", activityService.findAll());
		model.addAttribute("tasks", taskService.findAll());
		System.out.println("object: " + activity.toString());

		return "activity/crud";
	}

	@GetMapping("/delete/{activityId}")
	public String delete_GET(@PathVariable @Positive Long activityId, Model model) {

		try {
			activityService.deleteById(activityId);
			System.out.println("Deleted");
		} catch (Exception e) {
			System.out.println("Don't delete");
		}

		model.addAttribute("activity", new Activity());
		model.addAttribute("activities", activityService.findAll());
		model.addAttribute("tasks", taskService.findAll());

		return "activity/crud";
	}

}
