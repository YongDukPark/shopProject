package userlist.model;

import org.hibernate.validator.constraints.NotBlank;

public class DeleteuserBean {
	private final String must_input = "�Է����ּ���.";
	@NotBlank(message = "��й�ȣ�� "+must_input)
	private String pass;
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
