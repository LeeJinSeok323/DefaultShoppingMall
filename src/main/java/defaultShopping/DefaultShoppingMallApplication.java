package defaultShopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import defaultShopping.service.goods.GoodsListService;

@Controller
@SpringBootApplication
public class DefaultShoppingMallApplication {
	public static void main(String[] args) {
		SpringApplication.run(DefaultShoppingMallApplication.class, args);
	}
	
	@Autowired
	GoodsListService goodsListService;
	@RequestMapping("/")
	public String main(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/index";
	}

}
