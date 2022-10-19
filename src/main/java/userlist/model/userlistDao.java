package userlist.model;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("uDao")
public class userlistDao {
private String namespace="shop.userlist";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public int inserUser(userlistBean userBean) {
		// TODO Auto-generated method stub
	int cnt = sqlSessionTemplate.insert(namespace+".insertuser",userBean);
	return cnt;
	}
	public userlistBean searchId(String id) {
		userlistBean user= null;
		user = sqlSessionTemplate.selectOne(namespace+".searchId",id);
		return user;
	}
	public int UpdateUser(userlistBean user) {
		int cnt = sqlSessionTemplate.update(namespace+".updateuser",user);
		// TODO Auto-generated method stub
		return cnt;
	}
	public userlistBean SearchId(userlistBean user) {
		// TODO Auto-generated method stub
		userlistBean userid = sqlSessionTemplate.selectOne(namespace+".SearchId",user);
		return userid; 
		
	}
	public userlistBean SearchPass(userlistBean user) {
		// TODO Auto-generated method stub
		userlistBean userpass = sqlSessionTemplate.selectOne(namespace+".SearchPass",user);
		return userpass;
	}
	public int deleteuser(userlistBean user) {
	int cnt =sqlSessionTemplate.delete(namespace+".deleteuser",user);
		return cnt;
	}

}
