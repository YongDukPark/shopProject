package userlist.model;

import org.hibernate.validator.constraints.NotBlank;

public class DeleteuserBean {
	private final String must_input = "입력해주세요.";
	@NotBlank(message = "비밀번호를 "+must_input)
	private String pass;
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
