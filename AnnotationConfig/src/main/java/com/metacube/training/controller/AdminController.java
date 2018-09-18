package com.metacube.training.controller;

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
import com.metacube.training.model.JobTitleMaster;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skills;
import com.metacube.training.service.EmployeeInter;
import com.metacube.training.service.EmployeeSkillInter;
import com.metacube.training.service.JobDetailServicerInter;
import com.metacube.training.service.JobTitleInter;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillInter;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private SkillInter SkillService;
	@Autowired
	private EmployeeInter empService;
	@Autowired
	private JobTitleInter jobMaster;
	@Autowired
	private JobDetailServicerInter jobDetailService;
	@Autowired
	private EmployeeSkillInter EmployeeSkilllservice;

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	@GetMapping("/Logout")
	public String logOut() {
		return "redirect:../";
	}
	
	@GetMapping("/Dashboard")
	public String dashboard(){
	return "admin/dashboard";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "email") String username,
			@RequestParam(name = "password") String password) {
		// if(("namrata@gmail.com".equals(username) &&
		// ("1234".equals(password)))) {
		System.out.println("spring data");
		return new ModelAndView("admin/dashboard", "email", username);
		// } else
		// return new ModelAndView("admin/login");
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
		if (project != null && project.getProjectId() == 0) {
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
//
	@GetMapping("/Employees")
	public ModelAndView showEmployee(Model model) {
		model.addAttribute("Employees", empService.getAllEmployee());
		return new ModelAndView("admin/Employee");
	}

	
	 @RequestMapping(value = "/Employees/search", method = RequestMethod.POST)
	 public String searchEmployee(Model model,
	 @RequestParam("firstName") String name) {
	 model.addAttribute("employee", empService.getEmployeeByName(name));
	 return "redirect:/admin/Employees";
	
	 }
//
	@GetMapping("/Employees/add")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("jobTitles", jobMaster.getAllJobTitle());
		model.addAttribute("managerEmp", empService.getAllEmployee());
		model.addAttribute("teamLead", empService.getAllEmployee());
		model.addAttribute("currentProj", projectService.getAllProjects());
		model.addAttribute("skills", SkillService.getAllSkills());
		return "admin/addEmployee";
	}
//
	@GetMapping("/Employees/edit")
	public ModelAndView editEmployee(Model model, @RequestParam("id") int id) {
		model.addAttribute("employee", empService.getEmployeeById(id));
		return new ModelAndView("admin/editEmployee");
	}

	@GetMapping("/Employees/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		empService.deleteEmployee(id);
		return "redirect:/admin/Employees";
	}

	@RequestMapping(path = "/Employees", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			@ModelAttribute("jobDetails") JobDetails jobDetail,
			@RequestParam("skill") List<Integer> skills, Model model) {
		System.out.println(employee.getEmpCode());
		System.out.println(skills.toString());
		if (employee != null && employee.getEmpCode() == 0) {
			boolean result = empService.createEmployee(employee);
			if (result) {
				Employee emp = empService.getEmployeeByEmailId(employee
						.getEmailId());
				//System.out.println(emp.toString());

				jobDetail.setEmpCode(emp.getEmpCode());
				System.out.println(jobDetail.toString());
				jobDetailService.createJobDetail(jobDetail);
				System.out.println(skills.toString());
				for (Integer skillCode : skills) {
					EmployeeSkills employeeSkills = new EmployeeSkills();
					employeeSkills.setEmpCode(emp.getEmpCode());
					employeeSkills.setSkillCode(skillCode);
					EmployeeSkilllservice.createEmpSkills(employeeSkills);
					System.out.println(employeeSkills.toString());
				}
			}
		} else {
			empService.updateEmployee(employee);
		}
		return "redirect:/admin/Employees";
	}

	@GetMapping("/Search")
	public String searchEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		System.out.println("hii");
		return "/searchEmployee";

	}
//
//	

}
