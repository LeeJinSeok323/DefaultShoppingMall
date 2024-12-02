package defaultShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import defaultShopping.command.GoodsCommand;
import defaultShopping.service.goods.GoodsDetailService;
import defaultShopping.service.goods.GoodsListService;
import defaultShopping.service.goods.GoodsUpdateService;
import defaultShopping.service.goods.GoodsWriteService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsUpdateService goodsUpdateService;
	@GetMapping("form")
	public String form() {
		return "thymeleaf/goods/goodsForm";
	}
	@PostMapping("form/done")
	public String done(GoodsCommand goodsCommand, HttpServletRequest req) {
		goodsWriteService.execute(goodsCommand, req);
		return "redirect:/goods/list";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
	}
	
	@GetMapping("info")
	public String info(String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsDetail";
	}
	
	@GetMapping("edit")
	public String edit(String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsUpdate";
	}
	@PostMapping("edit/done")
	public String edited(GoodsCommand goodsCommand, HttpServletRequest request) {
		goodsUpdateService.execute(goodsCommand, request);
		return "redirect:/goods/info?goodsNum="+goodsCommand.getGoodsNum();
	}
}
