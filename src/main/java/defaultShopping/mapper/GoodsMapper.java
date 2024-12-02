package defaultShopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import defaultShopping.domain.GoodsDTO;

@Mapper
public interface GoodsMapper {
	public Integer goodsInsert(GoodsDTO goodsDTO);
	public List<GoodsDTO> selectGoodsList();
	public GoodsDTO selectGoodsOne(String goodsNum);
	public Integer updateGoods(GoodsDTO goodsDTO);
}
