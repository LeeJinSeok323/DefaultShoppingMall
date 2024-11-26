package defaultShopping.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import defaultShopping.domain.AuthInfoDTO;
import defaultShopping.mapper.LoginMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	public void execute(String userId, String userPw, HttpServletRequest request) {
		AuthInfoDTO auth = loginMapper.loginSelect(userId, userPw);
		HttpSession session = request.getSession();
		session.setAttribute("auth", auth);
		
	}
}
