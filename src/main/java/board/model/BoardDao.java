package board.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	private String namespace="board.model.Board";
	
	public int getArticleCount(Map<String, String> map) {
		int cnt=sqlSessionTemplate.selectOne(namespace+".GetArticleCount",map);
		return cnt;
	}
	public List<BoardBean> getArticleList(Paging pageInfo,Map<String, String> map){
		RowBounds rowBounds=new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		List<BoardBean> list=sqlSessionTemplate.selectList(namespace+".GetArticleList",map,rowBounds);
		return list;
	}
	public void insertArticle(BoardBean bean) {
		sqlSessionTemplate.insert(namespace+".InsertBoard",bean);
	}
	public void replyArticle(BoardBean bean) {
		bean.setRe_step(bean.getRe_step()+1);
		bean.setRe_level(bean.getRe_level()+1);
		sqlSessionTemplate.update(namespace+".ReplyArticle1",bean);
		sqlSessionTemplate.insert(namespace+".ReplyArticle2",bean);
	}
	public BoardBean getArticle(int number) {
		BoardBean bean=new BoardBean();
		sqlSessionTemplate.update(namespace+".AddReadCount",number);
		bean=sqlSessionTemplate.selectOne(namespace+".GetArticle",number);
		return bean;
	}
	public BoardBean oneSelect(int number) {
		BoardBean bean=new BoardBean();
		bean=sqlSessionTemplate.selectOne(namespace+".GetArticle",number);
		return bean;
	}
	public int deleteArticle(int num,String passwd) {
		int cnt=-1;
		String dbpw=sqlSessionTemplate.selectOne(namespace+".SelectPW",num);
		if(passwd.equals(dbpw)){
			cnt=sqlSessionTemplate.delete(namespace+".DeleteArticle",num);
		}
		return cnt;
	}
	public int deleteAdmin(int num) {
		int cnt=-1;
		cnt=sqlSessionTemplate.delete(namespace+".DeleteArticle",num);
		return cnt;
	}
	
	public int updateArticle(BoardBean bean){
		int cnt=-1;
		int num=bean.getNum();
		String dbpw=sqlSessionTemplate.selectOne(namespace+".SelectPW",num);
		if(bean.getPasswd().equals(dbpw)){
			cnt=sqlSessionTemplate.update(namespace+".UpdateArticle",bean);
		}
		return cnt;
	}
}