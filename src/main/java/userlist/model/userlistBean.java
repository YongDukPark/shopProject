package userlist.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class userlistBean {
	//private final String must_input = "�Է����ּ���.";
	private int num; 
	//@NotBlank(message = "���̵� "+must_input)
	
	private String id;
	//@NotBlank(message = "��й�ȣ�� "+must_input)
	private String pass;
	//@NotBlank(message = "��й�ȣ Ȯ���� "+must_input)
	private String repass;
	//@NotBlank(message = "�̸��� "+must_input)
	private String name;
	//@NotBlank(message = "������ �������ּ���.")
	private String gender;
	//@Pattern(regexp ="^(19[0-9][0-9]|20[0-9][0-9])(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$" ,message ="ex)19930405 ���ÿ� ������������ �Է����ּ���.")
	private int birth;
	private String pnum;
	//@NotBlank(message = "�ּҸ� "+must_input)
	private String address1;
	//@NotBlank(message = "���ּҸ� "+must_input)
	private String address2;
	private String insertdate;
	private int benpoint;
	private int grade;
	public String getRepass() {
		return repass;
	}
	public void setRepass(String repass) {
		this.repass = repass;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
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
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
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
	public String getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public int getBenpoint() {
		return benpoint;
	}
	public void setBenpoint(int benpoint) {
		this.benpoint = benpoint;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
}//userlistBean

