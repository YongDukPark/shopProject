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
	
	
	
	
	
	
	
	
	//�������
	
	
	
	
	
	
	
	
	//�̱� ��ǰ��ȣ�� ��������
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
	
	
	
	//singleOrderController ���� ��
	//�ȿ� sql�� num �����ؾ��� map �̿�
	public shopboxBean getSingleOrder(String id,String num) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		System.out.println("����¿���?");
		shopboxBean sbean = sqlSessionTemplate.selectOne(namespace + ".getSingleOrder",map);
		System.out.println("���⸦ �����°���?");
		
		return sbean;
	}
	
	//listOrderController ���� �� ��ٱ��� �����ֱ��
	public List<shopboxBean> getListOrder(String id) {
		
		List<shopboxBean> lists = new ArrayList<shopboxBean>(); 
		
		lists = sqlSessionTemplate.selectList(namespace+".getListOrder",id);
		
		return lists;
	}

	//listOrderController ���� ��
	public int getShopStock(int num) {
		System.out.println("listOrderController : " + num);
		int stockCheck = sqlSessionTemplate.selectOne(namespace+".selectStockCheck1",num);
		
		return stockCheck;
	}
	
	
	
	//������ bplist ��ǰ���� Ȯ��
	public int selectStockCheck1(String num) {
		
		int stockCheck = sqlSessionTemplate.selectOne(namespace+".selectStockCheck1",num);
		
		return stockCheck;
	}
	//������ shopbox ��ǰ���� Ȯ��
	public int selectStockCheck2(String num,String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", id);
		map.put("num", num);
		
		int stockCheck = sqlSessionTemplate.selectOne(namespace+".selectStockCheck2",map);
		
		return stockCheck;
	}
	
	//��ǰ��ȣ��� ��ȣ�� �ֹ������� shopbox���� �������� �װ� �� ����� down ��Ű��	
	//���� mav�� id�� name���� �ٲ����
	//singleOrderController2, listOrderController2 ���� �Ѿ��
	public int selectBynum(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);	//������ �Ѱ�
		
		// ��ǰ �ֹ��� ��������
		String stock = sqlSessionTemplate.selectOne(namespace+".selectBynum",map);
		
		
		map.put("stock", stock);	//���⼭ ������� �ֹ����� �������°�
		
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

	// orderLists ��
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
	
	//����� status �ٲ�� �ڵ�
	public void changeStatus(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		//��������� ����
		sqlSessionTemplate.update(namespace+".changeStatus",map);
		//��ٱ��� �����ð����� ����
		sqlSessionTemplate.update(namespace+".changeRegdate",map);
		
		
	}
	
	
	//��ǰ �ֹ����
	public void cancelOrder(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		sqlSessionTemplate.delete(namespace+".cancleOrder",map);
		
	}
	
	//�ɼ� �����ǰ
	public shopboxBean productDetail(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		shopboxBean bean = sqlSessionTemplate.selectOne(namespace+".productDetail",map);
		
		
		return bean;
	}
	
	
	//�ֹ���ǰ poption ����
	public void updateOptions(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		sqlSessionTemplate.update(namespace+".changeOptions",map);
		
	}
	
	
	
	//bean�� �ֱ��
	public shopboxBean getCheckList(String num, String id) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("num", num);
		
		shopboxBean bean = sqlSessionTemplate.selectOne(namespace+".getCheckList",map);
		
		return bean;
	}










	

	


	
}
