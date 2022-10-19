package userlist.model;

import org.hibernate.validator.constraints.NotBlank;

public class LoginBean {
	private final String must_input = "입력해주세요.";
	@NotBlank(message = "아이디를 "+must_input)
	private String id;
	@NotBlank(message = "비밀번호를 "+must_input)
	private String pass;
public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
