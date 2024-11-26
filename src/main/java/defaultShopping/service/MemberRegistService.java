package defaultShopping.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import defaultShopping.command.MemberCommand;
import defaultShopping.domain.MemberDTO;
import defaultShopping.mapper.MemberMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberRegistService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand, HttpServletRequest request) {
		MemberDTO dto = new MemberDTO();
		BeanUtils.copyProperties(memberCommand, dto);
		memberMapper.memberInsert(dto);
		
		// 회원가입이 되면 해당 아이디로 자동 로그인
		HttpSession session = request.getSession();
		
	}
}
