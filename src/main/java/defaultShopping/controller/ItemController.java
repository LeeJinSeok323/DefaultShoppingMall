package defaultShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import defaultShopping.service.goods.GoodsDetailService;

@Controller
@RequestMapping("item")
public class ItemController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@GetMapping("detailView")
	public String view(String goodsNum, Model model) {
		goodsDetailService.execute(goodsNum, model);
		return "thymeleaf/item/detailView";
	}
}
