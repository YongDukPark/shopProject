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
	
	//ben ����
	public void report(benlistBean bean) {
		
		sqlSessionTemplate.insert(namespace+".report",bean);
		
	}
	
	//benList ��¿�
	public List<benlistBean> getBenList() {
		List<benlistBean> lists = new ArrayList<benlistBean>();
		
		lists = sqlSessionTemplate.selectList(namespace+".getBenList");
		
		return lists;
	}
	
	//Report ����
	public void getByReport(String num) {
		//�Ѱ����� ���̵� ã�ƿ���
		String id = sqlSessionTemplate.selectOne(namespace+".getByUser",num);
		//���̵�� ulist report ����
		sqlSessionTemplate.update(namespace+".getByReport",id);
	}
	
	//Cancel ��ó
	public void getByCancel(String num) {
		sqlSessionTemplate.delete(namespace+".getByCancel",num);
	}

	//���� ��������
	public List<userlistBean_gang> count10up() {
		List<userlistBean_gang> lists = new ArrayList<userlistBean_gang>();
		
		lists = sqlSessionTemplate.selectList(namespace+".count10up");
		
		return lists;
	}
	
	//���� �����ϱ�
	public void userDelete(String num) {
		
		sqlSessionTemplate.delete(namespace+".userDelete",num);
		
	}
	
	
}
