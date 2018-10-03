package com.metacube.training.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Skills;
import com.metacube.training.service.EmployeeInter;
import com.metacube.training.service.EmployeeSkillInter;
import com.metacube.training.service.JobDetailServicerInter;
import com.metacube.training.service.JobTitleInter;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillInter;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private EmployeeInter empService;
	@Autowired
	private JobTitleInter jobtitleService;
	@Autowired
	private JobDetailServicerInter jobDetailService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private EmployeeSkillInter empSkillService;
	@Autowired
	private SkillInter skillService;
//
//	@GetMapping("/Dashboard")
//	public String dashboard(Model model) {
//		return "user/Profile";
//	}

	@GetMapping("/editProfile")
	public ModelAndView editprofile(Model model, @RequestParam("id") int id) {
		model.addAttribute("employee", empService.getEmployeeById(id));
		return new ModelAndView("user/editProfile");
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ModelAndView displayProfile(Model model,
			@ModelAttribute("employee") Employee emp) {
		if (empService.updateEmployee(emp)) {
			model.addAttribute("employee", emp);
		}
		return new ModelAndView("user/Profile");

	}

	@GetMapping("/Dashboard")
	public ModelAndView showprofile(Model model, Principal principal) {
		System.out.println("\n\n\n\n\n\n"+principal.getName());
		model.addAttribute("employee", empService.getEmployeeByEmailId(principal.getName()));
		return new ModelAndView("user/Profile");
	}

	@GetMapping("/professional")
	public ModelAndView professional(Model model, @RequestParam("id") int id) {
		System.out.println("professional");
		JobDetails jd = jobDetailService.getJobDetailByEmpId(id);
		model.addAttribute("jobDetails", jd);
		model.addAttribute("project",
				projectService.getProjectById(jd.getCurrProjId()));
		model.addAttribute("jobTitle",
				jobtitleService.getJobtitleById(jd.getJobCode()));
		model.addAttribute("manager",
				empService.getEmployeeById(jd.getReportingManagerId()));
		model.addAttribute("teamLead",
				empService.getEmployeeById(jd.getEmpCode()));
		List<EmployeeSkills> empSkillList = empSkillService.getSkillsByEmpId(jd
				.getEmpCode());
		List<Skills> skillList = new ArrayList<Skills>();
		for (EmployeeSkills Empskill : empSkillList) {
			Skills skill = skillService.getSkillsById(Empskill.getSkillCode());
			System.out.println(skill.toString());
			skillList.add(skill);
		}
		model.addAttribute("skillList", skillList);
		return new ModelAndView("user/professionalDetail");
	}

	@GetMapping("/Search")
	public String searchEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		System.out.println("hii");
		return "/searchEmployee";

	}

}