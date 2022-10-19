package notice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;


@Component("myNotice")
public class NoticeDao {
	private String namespace = "notice.NoticeBean";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//���ڵ� ����
	public int getTotalCount(Map<String, String> map) {
		//int cnt = -1;	 
		int cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}
	
	//������
	public List<NoticeBean> getNoticeList(Paging pageInfo, Map<String,String> map){
		List<NoticeBean> lists = new ArrayList<NoticeBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace + ".GetNoticeList", map, rowBounds);
		return lists;
	}
	
	//�߰�
	public int insertNotice(NoticeBean notic){
		int cnt = sqlSessionTemplate.insert(namespace+".InsertNotice", notic);
		return cnt;
	}
	
	//�����Ϸ�
	public NoticeBean getNotice(int num) {
		sqlSessionTemplate.update(namespace + ".AddReadCount",num);
		NoticeBean bean = sqlSessionTemplate.selectOne(namespace+".GetNotice",num);
		return bean;
	}
	
	//����
	public int updateNotice(NoticeBean nubean) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateNotice",nubean);
		return cnt;
		
	}
	//����
	public int deleteNotice(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".DeleteNotice" , num);
		return cnt;
	}
	
	//����Ŭ��  �󼼺���
	public NoticeBean getNoticenv(int num) {
		NoticeBean nvbean = sqlSessionTemplate.selectOne(namespace+".GetNoticenv",num);
		return nvbean;
	}
		
	//������ ��ȸ��
	public int addReadCount(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".AddReadCount",num);
		return cnt;
	}
	
	//��� �ۼ�
	public void replyNotice(NoticeBean nrbean,int restep, int relevel) {
		sqlSessionTemplate.update(namespace+".ReplyNotice1",nrbean);
		nrbean.setRestep(restep+1);
		nrbean.setRelevel(relevel+1);
		sqlSessionTemplate.insert(namespace+".ReplyNotice2",nrbean);
	}
}




