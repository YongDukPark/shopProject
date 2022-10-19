package userlist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shopbox.model.shopboxBean;
import utility.Paging;

@Component
public class userlistDao_gang {
	private String namespace="shop.userlist";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public List<userlistBean_gang> getUserList(Paging pageInfo, Map<String, String> map) {
		List<userlistBean_gang> list=new ArrayList<userlistBean_gang>();
		RowBounds rowBounds=new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		list=sqlSessionTemplate.selectList(namespace+".GetUserList",map,rowBounds);
		return list;
	}
	public int getTotalCount(Map<String, String> map) {
		int cnt=sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}
	public userlistBean_gang getUser(int num) {
		userlistBean_gang bean=sqlSessionTemplate.selectOne(namespace+".GetUser",num);
		return bean;
	}
	public void deleteUser(int num) {
		sqlSessionTemplate.delete(namespace+".DeleteUser",num);
	}
	public List<shopboxBean> paymentHistory(String id) {
		System.out.println(id);
		List<shopboxBean> list=new ArrayList<shopboxBean>();
		list=sqlSessionTemplate.selectList(namespace+".PaymentHistory",id);
		return list;
	}
}
