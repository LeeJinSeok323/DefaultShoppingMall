package defaultShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import defaultShopping.service.login.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	LoginService loginService;
	@GetMapping("/")
	public String openLoginPage() {
		return "thymeleaf/login/login";
	}
	@PostMapping("login")
	public String tryLogin(String userId, String userPw, HttpServletRequest request) {
		loginService.execute(userId, userPw, request);
		return "redirect:/";
	}
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("auth", null);
		return "redirect:/";
	}
}
