package defaultShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("memberDTO")
public class MemberDTO {
	String memberNum;
	String memberId;
	String memberPw;
	String memberName;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	char gender;
	String memberPhone1;
	String memberEmail;
	Date memberBirth;
	
	Date memberRegist;
	Integer memberPoint;
	char memberEmailConf;
	
	String memberPhone2;
	
}
