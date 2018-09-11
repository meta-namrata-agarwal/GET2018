package com.metaportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metaportal.modal.Employee;
import com.metaportal.modal.JobDetails;
import com.metaportal.modal.JobTitleMaster;
import com.metaportal.modal.Project;
import com.metaportal.modal.Skills;
import com.metaportal.service.EmployeeService;
import com.metaportal.service.JobTitleService;
import com.metaportal.service.ProjectService;
import com.metaportal.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "email") String username,
			@RequestParam(name = "password") String password) {
		 if(("namrata@gmail.com".equals(username)&&("1234".equals(password))))
		 {
		return new ModelAndView("admin/dashboard", "email", username);
		 }
		 else
		 return new ModelAndView("admin/login");
	}

	@GetMapping("/projects")
	public ModelAndView getAllprojects(Model model) {
		model.addAttribute("projects", ProjectService.getAllProjects());
		return new ModelAndView("admin/projects");
	}

	@GetMapping("/projects/edit")
	public ModelAndView editproject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", ProjectService.getProjectById(id));
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
			ProjectService.createProject(project);
		} else {
			ProjectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("id") int id) {
		ProjectService.deleteProject(id);
		return "redirect:/admin/projects";
	}
	
	@GetMapping("/skills")
	public ModelAndView showSkills(Model model)
	{
		model.addAttribute("skills",SkillService.getAllSkills());
		return new ModelAndView("admin/skills");
	}
	
	@GetMapping("/skills/add")
	public String addSkill(Model model){
		model.addAttribute("skill",new Skills());
		return "admin/editSkills";
	}
	
	@GetMapping("/skills/edit")
	public ModelAndView editSkill(Model model,@RequestParam("id") int id){
		model.addAttribute("skill",SkillService.getSkillsById(id));
		return new ModelAndView("admin/editSkills");
	}
	
	@GetMapping("/skills/delete")
	public String deleteSkill(@RequestParam("id") int id){
		SkillService.deleteSkills(id);
		return "redirect:/admin/skills";
	}
	 
	@RequestMapping(path = "/skills", method = RequestMethod.POST)
	public String saveSkills(@ModelAttribute("skill") Skills skill) {
		if (skill != null && skill.getSkillId() == 0) {
			System.out.println("hiii create");
			SkillService.createSkills(skill);;
		} else {
			System.out.println(skill.toString());
			System.out.println("hiii");
			SkillService.updateSkills(skill);;
			System.out.println(skill.toString());
			System.out.println("hiii23243");
		}
		return "redirect:/admin/skills";
	}
	@GetMapping("/jobs")
	public ModelAndView showJobTitle(Model model)
	{
		model.addAttribute("jobs",JobTitleService.getAllJobTitle());
		return new ModelAndView("admin/job");
	}
	
	@GetMapping("/jobs/add")
	public String addJobTitle(Model model){
		model.addAttribute("job",new JobTitleMaster());
		return "admin/addJobTitle";
	}
	
	@GetMapping("/jobs/edit")
	public ModelAndView editJobTitle(Model model,@RequestParam("id") int id){
		model.addAttribute("job",JobTitleService.getJobtitleById(id));
		return new ModelAndView("admin/addJobTitle");
	}
	
	@GetMapping("/jobs/delete")
	public String deleteJobTitle(@RequestParam("id") int id){
		JobTitleService.deletejobtitle(id);
		return "redirect:/admin/jobs";
	}
	 
	@RequestMapping(path = "/jobs", method = RequestMethod.POST)
	public String saveJobTitles(@ModelAttribute("job") JobTitleMaster job) {
		if (job != null && job.getJobCode() == 0) {
			JobTitleService.createJobTitle(job);;
		} else {
			JobTitleService.updateJobtitle(job);;
		}
		return "redirect:/admin/jobs";
	}

	@GetMapping("/Employees")
	public ModelAndView showEmployee(Model model)
	{
		model.addAttribute("Employees",EmployeeService.getAllEmployee());
		System.out.println("fiii");
		return new ModelAndView("admin/Employee");
	}
	
	@GetMapping("/Employees/add")
	public String addEmployee(Model model){
		model.addAttribute("employee",new Employee());
		return "admin/addEmployee";
	}
	
	@GetMapping("/Employees/edit")
	public ModelAndView editEmployee(Model model,@RequestParam("id") int id){
		model.addAttribute("employee",EmployeeService.getEmployeeById(id));
		return new ModelAndView("admin/addEmployee");
	}
	
	@GetMapping("/Employees/delete")
	public String deleteEmployee(@RequestParam("id") int id){
		EmployeeService.deleteEmployee(id);
		return "redirect:/admin/Employees";
	}
	 
	@RequestMapping(path = "/Employees", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println(employee.getEmpCode());
		if (employee != null && employee.getEmpCode() == 0) {
			EmployeeService.createEmployee(employee);;
		} else {
			EmployeeService.updateEmployee(employee);;
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
	{	model.addAttribute("details", new JobDetails());
		return "/Employees/addJobDetails";
	}
}
