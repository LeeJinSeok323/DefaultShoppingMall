package defaultShopping.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import defaultShopping.domain.EmployeeDTO;
import defaultShopping.domain.StartEndPageDTO;
import defaultShopping.mapper.EmployeeMapper;
import defaultShopping.service.StartEndPageService;

@Service
public class EmployeeListService {
	@Autowired
	StartEndPageService startEndPageService;
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(Integer page, String searchWord, Model model) {
		int listSize = 10;
		StartEndPageDTO sepDTO = startEndPageService.execute(page, listSize, searchWord);
		List<EmployeeDTO> list = employeeMapper.employeeSelectList(sepDTO);
		 
		int count = employeeMapper.employeeCount();
		startEndPageService.execute(page, listSize, count, searchWord, list, model);
	}
}
