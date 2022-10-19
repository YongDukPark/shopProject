package bplist.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class BplistBean {
	private int num;	//번호
	private String id;	//작성자
	private String content;	//설명
	private String img;	//상품사진
	private String ip;	
	
	@NotBlank(message="상품명 입력 필수")
	private String pname;	//상품명
	
	@NotBlank(message="성별 입력 필수,")
	private String gender;	//카테고리1(성별)
	
	@NotBlank(message="카테고리 입력 필수")
	private String category;	//카테고리2(품목)
	
	private int price;	//가격
	
	private String display;	//on-off
	private int stock;	//상품수량
	
	@NotBlank(message="옵션 입력 필수")
	private String poption;	//상품옵션
	
	private MultipartFile upload;


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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPoption() {
		return poption;
	}

	public void setPoption(String poption) {
		this.poption = poption;
	}

	
	// �뙆�씪 �뾽濡쒕뱶�슜
	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		// System.out.println("upload:" + upload); 
		// System.out.println("upload.getName:" + upload.getName());
		// System.out.println("upload.getOriginalFilename:" +upload.getOriginalFilename()); 
		img = upload.getOriginalFilename();
	}
	
}
