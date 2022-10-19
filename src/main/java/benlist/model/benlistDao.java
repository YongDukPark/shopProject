package benlist.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import userlist.model.userlistBean_gang;

@Component
public class benlistDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "shop.benlist";
	
	//ben 진행
	public void report(benlistBean bean) {
		
		sqlSessionTemplate.insert(namespace+".report",bean);
		
	}
	
	//benList 출력용
	public List<benlistBean> getBenList() {
		List<benlistBean> lists = new ArrayList<benlistBean>();
		
		lists = sqlSessionTemplate.selectList(namespace+".getBenList");
		
		return lists;
	}
	
	//Report 진행
	public void getByReport(String num) {
		//넘값으로 아이디 찾아오기
		String id = sqlSessionTemplate.selectOne(namespace+".getByUser",num);
		//아이디로 ulist report 진행
		sqlSessionTemplate.update(namespace+".getByReport",id);
	}
	
	//Cancel 선처
	public void getByCancel(String num) {
		sqlSessionTemplate.delete(namespace+".getByCancel",num);
	}

	//유저 가져오기
	public List<userlistBean_gang> count10up() {
		List<userlistBean_gang> lists = new ArrayList<userlistBean_gang>();
		
		lists = sqlSessionTemplate.selectList(namespace+".count10up");
		
		return lists;
	}
	
	//유저 삭제하기
	public void userDelete(String num) {
		
		sqlSessionTemplate.delete(namespace+".userDelete",num);
		
	}
	
	
}
