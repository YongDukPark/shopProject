package benlist.model;

import org.hibernate.validator.constraints.NotBlank;

public class benlistBean {
	private int num;
	private String id;
	
	@NotBlank(message = "내용을 작성해주세요.")
	private String reason;
	private int count;
	
	@NotBlank(message = "카테고리를 선택해주세요.")
	private String bencategory;
	private String coment;
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBencategory() {
		return bencategory;
	}
	public void setBencategory(String bencategory) {
		this.bencategory = bencategory;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	
	
}
