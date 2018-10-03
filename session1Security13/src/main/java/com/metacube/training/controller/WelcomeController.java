package com.metacube.training.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.Skills;
import com.metacube.training.service.EmployeeInter;
import com.metacube.training.service.EmployeeSkillInter;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillInter;

@Controller
public class WelcomeController {

	@Autowired
	private EmployeeInter employeeService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private SkillInter skillService;
	@Autowired
	private EmployeeSkillInter employeeSkillService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("hii");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("hii123");
		return "login";
	}

	@GetMapping("/Dashboard")
	public String dashboard(HttpServletRequest request) {
		if (request.isUserInRole("ADMIN")) {
			System.out.println("welcome dashboard");
			return "redirect:admin/Dashboard";
		} else {
			System.out.println("welcome user dashboard");
			return "redirect:user/Dashboard";
		}

	}

	@PostMapping("/searchResult")
	public String searchResult(@RequestParam(name = "type") String type,
			@RequestParam(name = "input") String input, Model model) {
		System.out.println(type);
		System.out.println(input);
		if ("name".equals(type)) {
			System.out.println(input);
			System.out.println(employeeService.getEmployeeByName(input)
					.toString());
			model.addAttribute("employees",
					employeeService.getEmployeeByName(input));
		} else if ("skill".equals(type)) {
			Skills skill = skillService.getSkillByName(input);
			System.out.println(skill.toString());
			if (skill != null) {
				List<EmployeeSkills> employeeSkills = employeeSkillService
						.getSkillsBySkillId(skill.getSkillId());
				List<Employee> employees = new ArrayList<Employee>();
				for (EmployeeSkills skills : employeeSkills) {
					employees.add(employeeService.getEmployeeById(skills
							.getEmpCode()));
				}
				model.addAttribute("employees", employees);
			}
			// } else if ("project".equals(type)) {
			// Project project = projectService.getProjectByName(input);
			// if (project != null) {
			// model.addAttribute("employees",
			// employeeService.getEmployeeByProject(project.getId()));
			// }
			// } else {
			// try {
			// Integer totalExp = Integer.parseInt(input);
			// model.addAttribute("employees",
			// employeeService.getEmployeeByTotalExperience(totalExp));
			// } catch (Exception e) {
			// return "redirect:search?error";
			// }
			// }

		}
		return "searchResult";
	}
}