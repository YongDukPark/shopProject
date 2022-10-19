package cmunity.model;

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
public class cmunityDao {
	
	private String namespace = "shop.cmunity";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	
	public int insert(cmunityBean bean) {
		
		int cnt = sqlSessionTemplate.insert(namespace+".insert",bean);
		
		return cnt;
	}
	
	public void insertProduct(cmunityBean bean, String number) {
		
		bean.setNum(Integer.valueOf(number));
		
		sqlSessionTemplate.insert(namespace + ".InsertProduct", bean);
	}
	
	

	public int totalCount(Map<String, String> map) {
		
		int totalCount = sqlSessionTemplate.selectOne(namespace+".getTotalCount",map);
		
		return totalCount;
	}


	public List<cmunityBean> List(Paging pageInfo, Map<String, String> map) {
		
		List<cmunityBean> lists = new ArrayList<cmunityBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".getLists",map,rowBounds);
		
		return lists;
	}

	//detail
	public cmunityBean detailView(String num) {
		
		cmunityBean bean = sqlSessionTemplate.selectOne(namespace+".detailView",num);
		
		return bean;
	}


	public void deleteByNum(String num) {
		
		sqlSessionTemplate.delete(namespace+".deleteByNum",num);
		
	}

	//readCount +1
	public void upReadCount(String num) {
		
		sqlSessionTemplate.update(namespace+".upReadCount",num);
		
	}

	//uplikecount +1
	public void uplikecount(String num) {
		int cnt = sqlSessionTemplate.update(namespace+".lCount",num);
		System.out.println("cnt:"+cnt);
		System.out.println("num:"+num);
	}


	public List<cmunityBean> getMainLike(cmunityBean bean) {
		List<cmunityBean> lists = new ArrayList<cmunityBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getMainLike",bean);
		return lists;
	}
	
	public List<cmunityBean> getMainGirl(cmunityBean bean) {
		List<cmunityBean> lists = new ArrayList<cmunityBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getMainGirl",bean);
		return lists;
	}
	
	public List<cmunityBean> getMainMen(cmunityBean bean) {
		List<cmunityBean> lists = new ArrayList<cmunityBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getMainMen",bean);
		return lists;
	}


	public int changeUpdate(cmunityBean bean) {
		int cnt = sqlSessionTemplate.update(namespace+".changeUpdate",bean);
		return cnt;
	}
	public int update(cmunityBean bean) {
		System.out.println("3bean:"+bean.getImg());
		int cnt = sqlSessionTemplate.update(namespace+".update",bean);
		return cnt;
	}


	public String getImgName(int num) {
		
		String beforeImge = sqlSessionTemplate.selectOne(namespace+".getImgName",num);
		
		return beforeImge;
	}

	public String getInsertNumber() {
		String number = sqlSessionTemplate.selectOne(namespace+".getInsertNumber");
		return number;
	}
	
	
	//´ñ±Û°ü·Ã
	public int insertreply(BpreplyBeanCmu replyBean) {
		int cnt = sqlSessionTemplate.insert(namespace + ".insertreplyCmu", replyBean);
		return cnt;
	}


	public BpreplyBeanCmu selectreply(int replenum) {
		BpreplyBeanCmu replyBean = sqlSessionTemplate.selectOne(namespace + ".selectreplyCmu", replenum);
		return replyBean;
	}
	public int updatereply(BpreplyBeanCmu replyBean) {
		int cnt = sqlSessionTemplate.update(namespace + ".updatereplyCmu", replyBean);
		return cnt;
	}
	public int deletereply(int replenum) {
		int cnt = sqlSessionTemplate.delete(namespace + ".deletereplyCmu", replenum);
		return cnt;
	}
	
	public List<BpreplyBeanCmu>  replylist(int num) {
		List<BpreplyBeanCmu> list = sqlSessionTemplate.selectList(namespace + ".replylistCmu",num);
		
		return list;
		
	}
	
	
	
}
