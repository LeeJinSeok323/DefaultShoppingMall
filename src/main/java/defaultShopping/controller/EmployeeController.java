package defaultShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import defaultShopping.command.EmployeeCommand;
import defaultShopping.mapper.EmployeeMapper;
import defaultShopping.service.employee.EmployeeDetailService;
import defaultShopping.service.employee.EmployeeListService;
import defaultShopping.service.employee.EmployeeRegistService;
import defaultShopping.service.employee.EmployeeUpdateService;

@Controller
@RequestMapping("user1")
public class EmployeeController {
	@Autowired
	EmployeeDetailService employeeDetailService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeRegistService employeeRegistService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@GetMapping("list")
	public String list(@RequestParam(defaultValue = "1", required = false) Integer page
					  ,@RequestParam(defaultValue = "", required = false) String keyword
					  ,Model model) {
		employeeListService.execute(page, keyword, model);
		return "thymeleaf/emp/employeeList";
	}
	@GetMapping("join/begin")
	public String form() {
		return "thymeleaf/emp/empForm";
	}
	@PostMapping("join/end")
	public String regist(EmployeeCommand employeeCommand) {
		employeeRegistService.execute(employeeCommand);
		return "redirect:/user1/list";
	}
	
	@GetMapping("info")
	public String info(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/emp/empInfo";
	}
	@GetMapping("edit")
	public String edit(String empNum, Model model) {
		employeeDetailService.execute(empNum, model);
		return "thymeleaf/emp/empInfoEdit";
	}
	@PostMapping("edit/done")
	public String update(EmployeeCommand employeeCommand) {
		employeeUpdateService.execute(employeeCommand);
		return "redirect:../info?empNum="+ employeeCommand.getEmpNum();
	}
	@Autowired
	EmployeeMapper employeeMapper;
	@GetMapping("del")
	public String delete(String empNum) {
		employeeMapper.employeeDelete(empNum);
		return "redirect:list";
	}
}
