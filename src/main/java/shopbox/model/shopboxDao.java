package shopbox.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class shopboxDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "shop.shopbox";
	
	//shopbox

	
	public void shopboxUpdate(String num, String stock, String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("num", num);
		map.put("stock", stock);
		map.put("id", id);
		
		
		sqlSessionTemplate.update(namespace+".shopboxUpdate",map);
		
	}
	
	public void shopboxInsert(shopboxBean bean) {
		
		sqlSessionTemplate.insert(namespace+".shopboxInsert",bean);
		
	}
	
	
	
	
	
	
	
	
	//여기까지
	
	
	
	
	
	
	
	
	//싱글 상품번호로 가져오기
	public shopboxBean getProduct(String bpnum) {
		shopboxBean bean = sqlSessionTemplate.selectOne(namespace+".getProduct",bpnum);
		
		return bean;
	}
	
	public void singleShopboxInsert(shopboxBean bean) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("id:"+bean.getId());
		System.out.println("num:"+bean.getNum());
		System.out.println("img:"+bean.getImg());
		System.out.println("pname:"+bean.getPname());
		System.out.println("price:"+bean.getPrice());
		System.out.println("stock:"+bean.getStock());
		System.out.println("options:"+bean.getPoption());
		
		
		
		map.put("id", bean.getId());
		map.put("num", String.valueOf(bean.getNum()));
		map.put("img", bean.getImg());
		map.put("pname", bean.getPname());
		map.put("price", String.valueOf(bean.getPrice()));
		map.put("stock", String.valueOf(bean.getStock()));
		map.put("poption", bean.getPoption());
		
		sqlSessionTemplate.insert(namespace+".singleShopboxInsert",map);
		
	}
	
	
	
	//singleOrderController 에서 옴
	//안에 sql문 num 수정해야함 map 이용
	public shopboxBean getSingleOrder(String id,String num) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		System.out.println("여기는오지?");
		shopboxBean sbean = sqlSessionTemplate.selectOne(namespace + ".getSingleOrder",map);
		System.out.println("여기를 못오는거지?");
		
		return sbean;
	}
	
	//listOrderController 에서 옴 장바구니 보여주기용
	public List<shopboxBean> getListOrder(String id) {
		
		List<shopboxBean> lists = new ArrayList<shopboxBean>(); 
		
		lists = sqlSessionTemplate.selectList(namespace+".getListOrder",id);
		
		return lists;
	}

	//listOrderController 에서 옴
	public int getShopStock(int num) {
		System.out.println("listOrderController : " + num);
		int stockCheck = sqlSessionTemplate.selectOne(namespace+".selectStockCheck1",num);
		
		return stockCheck;
	}
	
	
	
	//결제전 bplist 상품수량 확인
	public int selectStockCheck1(String num) {
		
		int stockCheck = sqlSessionTemplate.selectOne(namespace+".selectStockCheck1",num);
		
		return stockCheck;
	}
	//결제전 shopbox 상품수량 확인
	public int selectStockCheck2(String num,String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", id);
		map.put("num", num);
		
		int stockCheck = sqlSessionTemplate.selectOne(namespace+".selectStockCheck2",map);
		
		return stockCheck;
	}
	
	//상품번호기반 번호로 주문수량을 shopbox에서 가져오고 그걸 원 재고에서 down 시키기	
	//이후 mav에 id나 name으로 바꿔야함
	//singleOrderController2, listOrderController2 에서 넘어옴
	public int selectBynum(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);	//가져온 넘값
		
		// 상품 주문량 가져오기
		String stock = sqlSessionTemplate.selectOne(namespace+".selectBynum",map);
		
		
		map.put("stock", stock);	//여기서 만들어진 주문수량 가져오는값
		
		//bplist down stock
		int update = sqlSessionTemplate.update(namespace+".updateStock",map);
		
		map.remove("num");
		map.remove("stock");
		map.remove("id");
		
		return update;
	}

	public int totalCount(Map<String, String> map) {

		int totalCount = sqlSessionTemplate.selectOne(namespace+".totalCount",map);
		
		System.out.println("totalCount:"+totalCount );
		return totalCount;
	}

	// orderLists 용
	public List<shopboxBean> getOrderList(Paging pageInfo, Map<String, String> map) {
		
		List<shopboxBean> lists = new ArrayList<shopboxBean>();
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		lists = sqlSessionTemplate.selectList(namespace+".GetProductList",map,rowBounds);
		
		return lists;
		
	}

	public int totalPrice(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		int price = sqlSessionTemplate.selectOne(namespace+".totalPrice",map);
		int stock = sqlSessionTemplate.selectOne(namespace+".totalStock",map);
		int totalPrice = price*stock;
		
		return totalPrice;
	}
	
	//결재시 status 바뀌는 코드
	public void changeStatus(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		//배송중으로 변경
		sqlSessionTemplate.update(namespace+".changeStatus",map);
		//장바구니 담은시간에서 변경
		sqlSessionTemplate.update(namespace+".changeRegdate",map);
		
		
	}
	
	
	//상품 주문취소
	public void cancelOrder(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		sqlSessionTemplate.delete(namespace+".cancleOrder",map);
		
	}
	
	//옵션 변경상품
	public shopboxBean productDetail(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		shopboxBean bean = sqlSessionTemplate.selectOne(namespace+".productDetail",map);
		
		
		return bean;
	}
	
	
	//주문상품 poption 변경
	public void updateOptions(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		sqlSessionTemplate.update(namespace+".changeOptions",map);
		
	}
	
	
	
	//bean에 넣기용
	public shopboxBean getCheckList(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		shopboxBean bean = sqlSessionTemplate.selectOne(namespace+".getCheckList",map);
		
		return bean;
	}










	

	


	
}
