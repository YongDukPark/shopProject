package cmunity.model;

import org.springframework.web.multipart.MultipartFile;

public class cmunityBean {
	private int num;
	private String id;
	private String img;
	private String changeimg;
	private String subject;
	private String gender;	
	private String content;
	private int readcount;
	private String regdate;
	private String ip;
	private String pname;
	private String category;
	private String price;
	private String stock;
	private String poption;
	private int likecount;
	
	private MultipartFile upload;
	
	
	
	public String getChangeimg() {
		return changeimg;
	}
	public void setChangeimg(String changeimg) {
		this.changeimg = changeimg;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
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
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getPoption() {
		return poption;
	}
	public void setPoption(String poption) {
		this.poption = poption;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	
	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		System.out.println("이름 : "+upload.getOriginalFilename());
		System.out.println("길이:"+upload.getOriginalFilename().length());
		if(upload.getOriginalFilename().length() != 0) { //아무것도 안넣었을경우 글자수가 0 이 나오기에 img에 original name에 안들어감
			img = upload.getOriginalFilename();
			System.out.println("1번");
		}
		else {
			System.out.println("2번");
			//img = img;
		}
	}
	
}
