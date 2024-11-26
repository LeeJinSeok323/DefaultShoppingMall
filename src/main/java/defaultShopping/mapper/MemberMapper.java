package defaultShopping.mapper;

import org.apache.ibatis.annotations.Mapper;

import defaultShopping.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public Integer memberInsert(MemberDTO dto);
}
