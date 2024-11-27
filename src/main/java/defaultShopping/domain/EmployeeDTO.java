package defaultShopping.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Alias("employeeDTO")
public class EmployeeDTO {
	String empNum;
	String empId;
	String empPw;
	String empName;
	String empAddr;
	String empAddrDetail;
	String empPost;
	String empPhone;
	String empJumin;
	String empEmail;
	String empHireDate;
	String empOriginalImage;
	String empStoreImage;
}
