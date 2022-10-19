package userlist.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class SearchpassBean {
private final String must_input = "�Է����ּ���.";
	
	@NotBlank(message = "�̸��� "+must_input)

	private String name;
	
	@NotBlank(message = "���̵� "+must_input)
	
	private String id;
	

	@Pattern(regexp ="^(19[0-9][0-9]|20[0-9][0-9])(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$" ,message ="ex)19930405 ���ÿ� ������������ �Է����ּ���.")
	private String birth;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
}
