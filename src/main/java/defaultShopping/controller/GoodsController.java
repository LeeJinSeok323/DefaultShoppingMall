package defaultShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import defaultShopping.command.GoodsCommand;
import defaultShopping.service.goods.GoodsWriteService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsWriteService goodsWriteService;
	@GetMapping("form")
	public String form() {
		return "thymeleaf/goods/goodsForm";
	}
	@PostMapping("done")
	public String done(GoodsCommand goodsCommand, HttpServletRequest req) {
		goodsWriteService.execute(goodsCommand, req);
		return "redirect:/goods/list";
	}
	
	@GetMapping("list")
	public String list() {
		return "thymeleaf/goods/goodsList";
	}
}
