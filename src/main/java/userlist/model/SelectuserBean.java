package userlist.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class SelectuserBean {
	private final String must_input = "입력해주세요.";	
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
