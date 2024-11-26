package defaultShopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import defaultShopping.domain.AuthInfoDTO;

@Mapper
public interface LoginMapper {
	public AuthInfoDTO loginSelect(@Param(value = "userId") String userId,
								   @Param(value = "userPw") String userPw);
}
