package defaultShopping.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCommand {
	String goodsName;
	int goodsPrice;
	String goodsContents;
	MultipartFile goodsMainImage;
	MultipartFile[] goodsDetailImage;
}
