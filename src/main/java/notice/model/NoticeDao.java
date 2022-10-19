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
	
	//레코드 갯수
	public int getTotalCount(Map<String, String> map) {
		//int cnt = -1;	 
		int cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}
	
	//페이지
	public List<NoticeBean> getNoticeList(Paging pageInfo, Map<String,String> map){
		List<NoticeBean> lists = new ArrayList<NoticeBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace + ".GetNoticeList", map, rowBounds);
		return lists;
	}
	
	//추가
	public int insertNotice(NoticeBean notic){
		int cnt = sqlSessionTemplate.insert(namespace+".InsertNotice", notic);
		return cnt;
	}
	
	//수정완료
	public NoticeBean getNotice(int num) {
		sqlSessionTemplate.update(namespace + ".AddReadCount",num);
		NoticeBean bean = sqlSessionTemplate.selectOne(namespace+".GetNotice",num);
		return bean;
	}
	
	//수정
	public int updateNotice(NoticeBean nubean) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateNotice",nubean);
		return cnt;
		
	}
	//삭제
	public int deleteNotice(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".DeleteNotice" , num);
		return cnt;
	}
	
	//제목클릭  상세보기
	public NoticeBean getNoticenv(int num) {
		NoticeBean nvbean = sqlSessionTemplate.selectOne(namespace+".GetNoticenv",num);
		return nvbean;
	}
		
	//디테일 조회수
	public int addReadCount(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".AddReadCount",num);
		return cnt;
	}
	
	//답글 작성
	public void replyNotice(NoticeBean nrbean,int restep, int relevel) {
		sqlSessionTemplate.update(namespace+".ReplyNotice1",nrbean);
		nrbean.setRestep(restep+1);
		nrbean.setRelevel(relevel+1);
		sqlSessionTemplate.insert(namespace+".ReplyNotice2",nrbean);
	}
}




