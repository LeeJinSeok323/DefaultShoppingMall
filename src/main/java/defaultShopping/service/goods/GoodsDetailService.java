package defaultShopping.service.goods;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import defaultShopping.domain.GoodsDTO;
import defaultShopping.mapper.GoodsMapper;

@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, Model model) {
		GoodsDTO dto = goodsMapper.selectGoodsOne(goodsNum);
		
		String[] goodsDetailStoreImage = dto.getGoodsDetailStoreImage().split("/");
		String[] goodsDetailImage = dto.getGoodsDetailImage().split("/");
		String[] category = dto.getCategory().split(" ");
		
		model.addAttribute("goodsDetailImage", goodsDetailImage);
		model.addAttribute("goodsDetailStoreImage", goodsDetailStoreImage);
		model.addAttribute("category", category);
		model.addAttribute("goodsCommand",dto);
	}
}
