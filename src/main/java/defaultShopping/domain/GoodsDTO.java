package defaultShopping.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Alias("goodsDTO")
public class GoodsDTO {
	String goodsNum;
	String goodsName;
	int goodsPrice;
	String goodsContents;
	int visitCount;
	String goodsMainImage;
	String goodsMainStoreImage;
	String goodsDetailImage;
	String goodsDetailStoreImage;
	String empNum;
	Date goodsRegist;
	String updateEmpNum;
	Date goodsUpdateDate;
}
