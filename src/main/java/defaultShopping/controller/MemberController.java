package defaultShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import defaultShopping.command.MemberCommand;
import defaultShopping.service.MemberRegistService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user2")
public class MemberController {
	@Autowired
	MemberRegistService memberRegistService;
	@GetMapping("join/agree")
	public String agree() {
		return "thymeleaf/user2/agree";
	}
	@PostMapping("join/begin")
	public String begin(MemberCommand memberCommand, Model model) {
		model.addAttribute(memberCommand);
		return "thymeleaf/user2/registerForm";
	}
	@PostMapping("join/end")
	public String end(MemberCommand memberCommand,
					  BindingResult result,
					  HttpServletRequest request) {
		/* 나중에 js로 하던 다시 처리
		if(result.hasErrors()) {
			return "thymeleaf/user2/registerForm";
		}
		if(!memberCommand.memberPwIsEqualMemberPwCon()) {
			result.rejectValue("memberPwCon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/user2/registerForm";
		}
		*/
		memberRegistService.execute(memberCommand, request);
		return "redirect:/";
	}
	
}
