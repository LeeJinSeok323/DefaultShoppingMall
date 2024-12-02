package defaultShopping.service.goods;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import defaultShopping.command.GoodsCommand;
import defaultShopping.domain.AuthInfoDTO;
import defaultShopping.domain.GoodsDTO;
import defaultShopping.mapper.AutoNumMapper;
import defaultShopping.mapper.GoodsMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsUpdateService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	AutoNumMapper autoNumMapper;
	public void execute(GoodsCommand goodsCommand, HttpServletRequest request) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsContents(goodsCommand.getGoodsContents());
		
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String empNum = autoNumMapper.getNumById(auth.getUserId());
		dto.setUpdateEmpNum(empNum);
		
		// fileDir
		URL resource = getClass().getClassLoader().getResource("static/upload");
		String fileDir = resource.getFile();
		
		// MainImageFile
		String extension, storeName, storeFileName;
		File file;
		MultipartFile mf = goodsCommand.getGoodsMainImage();
		String originalFile = mf.getOriginalFilename();
		if(!originalFile.isEmpty()) {
			extension = originalFile.substring(originalFile.lastIndexOf('.'));
			storeName = UUID.randomUUID().toString().replace("-", "");
			storeFileName = storeName + extension;
			dto.setGoodsMainImage(originalFile);
			dto.setGoodsMainStoreImage(storeFileName);
			
			file = new File( fileDir + '/' + storeFileName);
			
			try {
				mf.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		// GoodsDetail Images
		if(!goodsCommand.getGoodsDetailImage()[0].getOriginalFilename().isEmpty()) {
			String originalTotal ="";
			String storeTotal = "";
			for(MultipartFile mf1 : goodsCommand.getGoodsDetailImage()) {
				originalFile = mf1.getOriginalFilename();
				
				// 저장하기 위한 이름 만들기 : UUID
				extension = originalFile.substring(originalFile.lastIndexOf("."));
				storeName = UUID.randomUUID().toString().replace("-", "");
				storeFileName = storeName + extension;
				file = new File(fileDir + "/" + storeFileName);
				try {
					mf1.transferTo(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				originalTotal += originalFile + "/";
				storeTotal += storeFileName + "/";
				
			}
			dto.setGoodsDetailImage(originalTotal);
			dto.setGoodsDetailStoreImage(storeTotal);
		}
		
		// 기존 파일 삭제를 위한 정보 미리 받아오기
		//GoodsDTO oldDTO = goodsMapper.selectGoodsOne(goodsCommand.getGoodsNum());
		goodsMapper.updateGoods(dto);
		
		
	}
}
