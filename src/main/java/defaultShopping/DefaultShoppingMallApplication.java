package defaultShopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class DefaultShoppingMallApplication {
	public static void main(String[] args) {
		SpringApplication.run(DefaultShoppingMallApplication.class, args);
	}
	
	@RequestMapping("/")
	public String main() {
		return "thymeleaf/index";
	}

}
