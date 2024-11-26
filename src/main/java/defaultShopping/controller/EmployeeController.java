package defaultShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import defaultShopping.service.employee.EmployeeListService;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeeListService employeeListService;
	@GetMapping("list")
	public String list(@RequestParam(defaultValue = "1", required = false) Integer page
					  ,@RequestParam(defaultValue = "", required = false) String keyword
					  ,Model model) {
		employeeListService.execute(page, keyword, model);
		return "thymeleaf/emp/employeeList";
	}
	@GetMapping("form")
	public String form() {
		return "thymeleaf/emp/empForm";
	}
}
