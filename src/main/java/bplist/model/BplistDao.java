package bplist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cmunity.model.cmunityBean;
import utility.Paging;

@Component  /* ("myBplistDao") */
public class BplistDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "shop.bplist";
	// java.lang.IllegalArgumentException: mapper�쓽 namespace�� �씪移섏떆耳쒖빞 �븿!
	
	//////////////////////////////////////////////////
	
	
	public int totalCount(Map<String, String> map) {

		int count = sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
		return count;
	} // totalCount
	
	
	// �썝�븯�뒗 �럹�씠吏� �닔�뿉 �썝�븯�뒗 媛쒖닔留뚰겮 異쒕젰�븯寃� �빐 二쇰뒗 硫붿꽌�뱶
	public List<BplistBean> productList(Paging pageInfo, Map<String, String> map) {
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<BplistBean> list = sqlSessionTemplate.selectList(namespace + ".ProductList", map, rowBounds);
		
		return list;
	}	// productList
	
	
	
	public BplistBean getProduct(int num) {

		BplistBean bb = sqlSessionTemplate.selectOne(namespace + ".GetProduct", num);
		return bb;
	}	// getProduct

	

	public int insertProduct(BplistBean bb) {
	
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".InsertProduct", bb);
		return cnt;
	}	// insertProduct

	

	public int deleteProduct(int num) {
	
		int cnt = sqlSessionTemplate.delete(namespace+".DeleteProduct", num);
		return cnt;
	}	// deleteProduct


	
	public int updateProduct(BplistBean bb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateProduct", bb);
		return cnt;
	}	// updateProduct



	//////////////////////////
	

	
	public List<BplistBean> getMainStock(BplistBean bean) {
		List<BplistBean> lists = new ArrayList<BplistBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetMainStock",bean);
		return lists;
	}


	public List<BplistBean> getMainPrice(BplistBean bean) {
		List<BplistBean> lists = new ArrayList<BplistBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetMainPrice",bean);
		return lists;
	}


	public List<BplistBean> getMainWemen(BplistBean bean) {
		List<BplistBean> lists = new ArrayList<BplistBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetMainWemen",bean);
		return lists;
	}


	public List<BplistBean> getMainMen(BplistBean bean) {
		List<BplistBean> lists = new ArrayList<BplistBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetMainMen",bean);
		return lists;
	}
	
	
	
	public List<BpreplyBean>  replylist(int num) {
		List<BpreplyBean> list = sqlSessionTemplate.selectList(namespace + ".replylist",num);
		
		return list;
		
	}


	public int insertreply(BpreplyBean replyBean) {
		// TODO Auto-generated method stub
		int cnt = sqlSessionTemplate.insert(namespace + ".insertreply", replyBean);
		return cnt;
	}


	public BpreplyBean selectreply(int replenum) {
		// TODO Auto-generated method stub
		BpreplyBean replyBean = sqlSessionTemplate.selectOne(namespace + ".selectreply", replenum);
		return replyBean;
	}
	public int updatereply(BpreplyBean replyBean) {
		// TODO Auto-generated method stub
		int cnt = sqlSessionTemplate.update(namespace + ".updatereply", replyBean);
		return cnt;
	}
	public int deletereply(int replenum) {
		// TODO Auto-generated method stub
		int cnt = sqlSessionTemplate.delete(namespace + ".deletereply", replenum);
		return cnt;
	}
	
	
	
}
