package defaultShopping.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeCommand {
	String empId;
	String empPw;
	String empPwCon;
	String empName;
	String empAddr;
	String empAddrDetail;
	String empPost;
	String empPhone;
	String empJumin;
	String empEmail;
	String empHireDate;
	MultipartFile empImage;
}
