package com.meta.training.EmployeePortal.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.meta.training.EmployeePortal.modal.Employee;
import com.meta.training.EmployeePortal.modal.JobDetails;
import com.meta.training.EmployeePortal.modal.JobTitleMaster;

import com.meta.training.EmployeePortal.modal.Project;
import com.meta.training.EmployeePortal.modal.Skills;

import com.meta.training.EmployeePortal.service.EmployeeService;
import com.meta.training.EmployeePortal.service.JobTitleService;
import com.meta.training.EmployeePortal.service.ProjectService;
import com.meta.training.EmployeePortal.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController  {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private SkillService SkillService;
	 @Autowired
	 private EmployeeService empService;
	@Autowired
	private JobTitleService jobMaster;


	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "email") String username,
			@RequestParam(name = "password") String password) {
		if(("namrata@gmail.com".equals(username) && ("1234".equals(password)))) {
			return new ModelAndView("admin/dashboard", "email", username);
		} else
			return new ModelAndView("admin/login");
	}

	@GetMapping("/projects")
	public ModelAndView getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return new ModelAndView("admin/projects");
	}

	@GetMapping("/projects/edit")
	public ModelAndView editproject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return new ModelAndView("admin/editProject");
	}

	@GetMapping("/projects/add")
	public String addproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if (project != null && project.getId() == 0) {
			projectService.createProject(project);
		} else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("id") int id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}

	@GetMapping("/skills")
	public ModelAndView showSkills(Model model) {
		model.addAttribute("skills", SkillService.getAllSkills());
		return new ModelAndView("admin/skills");
	}

	@GetMapping("/skills/add")
	public String addSkill(Model model) {
		model.addAttribute("skill", new Skills());
		return "admin/editSkills";
	}

	@GetMapping("/skills/edit")
	public ModelAndView editSkill(Model model, @RequestParam("id") int id) {
		model.addAttribute("skill", SkillService.getSkillsById(id));
		return new ModelAndView("admin/editSkills");
	}

	@GetMapping("/skills/delete")
	public String deleteSkill(@RequestParam("id") int id) {
		SkillService.deleteSkills(id);
		return "redirect:/admin/skills";
	}

	@RequestMapping(path = "/skills", method = RequestMethod.POST)
	public String saveSkills(@ModelAttribute("skill") Skills skill) {
		if (skill != null && skill.getSkillId() == 0) {
			System.out.println("hiii create");
			SkillService.createSkills(skill);
			;
		} else {
			System.out.println(skill.toString());
			System.out.println("hiii");
			SkillService.updateSkills(skill);
			;
			System.out.println(skill.toString());
			System.out.println("hiii23243");
		}
		return "redirect:/admin/skills";
	}

	@GetMapping("/jobs")
	public ModelAndView showJobTitle(Model model) {
		model.addAttribute("jobs", jobMaster.getAllJobTitle());
		return new ModelAndView("admin/job");
	}

	@GetMapping("/jobs/add")
	public String addJobTitle(Model model) {
		model.addAttribute("job", new JobTitleMaster());
		return "admin/addJobTitle";
	}

	@GetMapping("/jobs/edit")
	public ModelAndView editJobTitle(Model model, @RequestParam("id") int id) {
		model.addAttribute("job", jobMaster.getJobtitleById(id));
		return new ModelAndView("admin/addJobTitle");
	}

	@GetMapping("/jobs/delete")
	public String deleteJobTitle(@RequestParam("id") int id) {
		jobMaster.deletejobtitle(id);
		return "redirect:/admin/jobs";
	}

	@RequestMapping(path = "/jobs", method = RequestMethod.POST)
	public String saveJobTitles(@ModelAttribute("job") JobTitleMaster job) {
		if (job != null && job.getJobCode() == 0) {
			jobMaster.createJobTitle(job);
			;
		} else {
			jobMaster.updateJobtitle(job);
			;
		}
		return "redirect:/admin/jobs";
	}

	 @GetMapping("/Employees")
	 public ModelAndView showEmployee(Model model)
	 {
	 model.addAttribute("Employees",empService.getAllEmployee());
	 System.out.println("fiii");
	 return new ModelAndView("admin/Employee");
	 }
	 @RequestMapping(value="/Employees/search",method=RequestMethod.POST)
	 public String searchEmployee(Model model,@RequestParam("firstName") String name){
		 System.out.println(name);
		 model.addAttribute("employee",empService.EmpByName(name));
		return "redirect:/admin/Employees";
		 
	 }
	
	 @GetMapping("/Employees/add")
	 public String addEmployee(Model model){
	 model.addAttribute("employee",new Employee());
	 return "admin/addEmployee";
	 }
	
	 @GetMapping("/Employees/edit")
	 public ModelAndView editEmployee(Model model,@RequestParam("id") int id){
	 model.addAttribute("employee",empService.getEmployeeById(id));
	 return new ModelAndView("admin/addEmployee");
	 }
	
	 @GetMapping("/Employees/delete")
	 public String deleteEmployee(@RequestParam("id") int id){
	 empService.deleteEmployee(id);
	 return "redirect:/admin/Employees";
	 }
	
	 @RequestMapping(path = "/Employees", method = RequestMethod.POST)
	 public String saveEmployee(@ModelAttribute("employee") Employee employee)
	 {
	 System.out.println(employee.getEmpCode());
	 if (employee != null && employee.getEmpCode() == 0) {
	 boolean result=empService.createEmployee(employee);
	 
	 } else {
	 empService.updateEmployee(employee);;
	 }
	 return "redirect:/admin/Employees";
	 }
	
	 @GetMapping("/Employees/Search")
	 public String searchEmployee(Model model){
	 model.addAttribute("employee",new Employee());
	 System.out.println("hii");
	 return "admin/searchEmployee";
	
	 }
	
	 @GetMapping("/Employees/addJobDetails")
	 public String addJobDetails(Model model,@RequestParam("id") int id)
	 { model.addAttribute("details", new JobDetails());
	 return "/Employees/addJobDetails";
	 }

	
}


