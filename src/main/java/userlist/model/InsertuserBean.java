package userlist.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class InsertuserBean {
	private final String must_input = "입력해주세요.";	
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9]{4,11}$",message = "시작은 영문으로만, 영문, 숫자로 이루어진 5~12자 이하의 아이디를 입력해주세요 ")	
	private String id;
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9]{5,13}$",message="시작은 영문으로만, 영문, 숫자로 이루어진 6~14자 이하의 비밀번호를 입력해주세요.")
	private String pass;
	@NotBlank(message = "비밀번호 확인을 "+must_input)
	private String repass;
	@NotBlank(message = "이름을 "+must_input)
	private String name;
	@NotBlank(message = "성별을 선택해주세요.")
	private String gender;
	@Pattern(regexp ="^(19[0-9][0-9]|20[0-9][0-9])(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$" ,message ="ex)19930405 예시와 같은형식으로 입력해주세요.")
	private String birth;	
	@NotBlank(message = "주소를 "+must_input)
	private String address1;
	@NotBlank(message = "상세주소를 "+must_input)
	private String address2;
	
	
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
public String getRepass() {
	return repass;
}
public void setRepass(String repass) {
	this.repass = repass;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBirth() {
	return birth;
}
public void setBirth(String birth) {
	this.birth = birth;
}
public String getAddress1() {
	return address1;
}
public void setAddress1(String address1) {
	this.address1 = address1;
}
public String getAddress2() {
	return address2;
}
public void setAddress2(String address2) {
	this.address2 = address2;
}

}