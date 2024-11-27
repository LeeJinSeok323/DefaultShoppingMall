package defaultShopping.service.employee;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import defaultShopping.command.EmployeeCommand;
import defaultShopping.domain.EmployeeDTO;
import defaultShopping.mapper.AutoNumMapper;
import defaultShopping.mapper.EmployeeMapper;

@Service
public class EmployeeRegistService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	AutoNumMapper autoNumMapper;
	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(employeeCommand, dto);
		
		String empNum = autoNumMapper.AutoNumSelect("emp", "emp_num", 4, "employees");
		dto.setEmpNum(empNum);
		
		
		MultipartFile mf = employeeCommand.getEmpImage();
		if(mf != null && !mf.isEmpty()) {
			String original = mf.getOriginalFilename();
			String extension = original.substring(original.lastIndexOf('.'));
			String store = UUID.randomUUID().toString().replace("-", "");
			String storeFile = store + extension;
			
			dto.setEmpOriginalImage(original);
			dto.setEmpStoreImage(storeFile);
		}
		
		
		employeeMapper.employeeInsert(dto);
	}
}
