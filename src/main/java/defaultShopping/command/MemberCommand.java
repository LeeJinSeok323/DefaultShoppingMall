package defaultShopping.command;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberCommand {
	@NotEmpty(message = "아이디는 필수 입력값입니다")
	@Pattern(regexp = "^[a-z0-9]{5,20}$"
		    ,message = "아이디는 영어 소문자와 숫자만 사용하여 5~20자리여야 합니다.")
	String memberId;
	
	@NotEmpty(message = "비밀번호는 필수 입력값입니다")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$"
    		,message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
	String memberPw;
	
	@NotEmpty(message = "비밀번호 확인은 필수 입력값입니다")
	String memberPwCon;
	
	String memberName;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	char gender;
	String memberPhone1;
	String memberEmail;
	Date memberBirth;
	
	public boolean memberPwIsEqualMemberPwCon() {
		boolean isEqual = memberPw.equals(memberPwCon);
		return isEqual;
	}
}
