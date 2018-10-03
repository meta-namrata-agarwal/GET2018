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
import com.meta.training.EmployeePortal.service.EmployeeService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private EmployeeService empService;
//	@Autowired
//	private JobTitleService jobtitleService;
//	@Autowired
//	private JobDetailsService jobDetailService;
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@GetMapping("/Logout")
	public String logOut() {
		return "redirect:../";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Model model,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		Employee emp = empService.loginParam(email, password);
		// System.out.println(emp.getEmailId());
		// System.out.println(emp.getPassword());
		// if (emp != null) {
		model.addAttribute("employee", emp);
		return new ModelAndView("user/Profile");
		// } else
		// return new ModelAndView("redirect:user/login");
	}

	@GetMapping("/editProfile")
	public ModelAndView editprofile(Model model, @RequestParam("id") int id) {
		model.addAttribute("employee", empService.getEmployeeById(id));
		return new ModelAndView("user/editProfile");
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ModelAndView displayProfile(Model model,
			@ModelAttribute("employee") Employee emp) {
		if (empService.editEmpProfile(emp)) {
			model.addAttribute("employee", emp);
		}
		return new ModelAndView("user/Profile");

	}

	

	@GetMapping("/professional")
	public ModelAndView professional(Model model, @RequestParam("id") int id) {
		System.out.println("professional");
		//JobDetails jd= jobDetailService.getJobtitleById(id);
		//model.addAttribute("jobDetails", jobtitleService.getjobDetails(jd.getEmpCode()));
		return new ModelAndView("user/professionalDetail");
	}

}