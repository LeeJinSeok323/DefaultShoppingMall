package defaultShopping.mapper;

import org.apache.ibatis.annotations.Mapper;

import defaultShopping.domain.GoodsDTO;

@Mapper
public interface GoodsMapper {
	public Integer goodsInsert(GoodsDTO goodsDTO);
}
