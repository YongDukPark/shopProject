package bplist.model;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class BpreplyBean {
	private int replenum;
private int num;
private String content;
private String img;
private String insertdate;
private String id;

private MultipartFile upload;
private String type;

public BpreplyBean() {
	super();
}
public int getReplenum() {
	return replenum;
}
public void setReplenum(int replenum) {
	this.replenum = replenum;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
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
public String getInsertdate() {
	return insertdate;
}
public void setInsertdate(String insertdate) {
	this.insertdate = insertdate;
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public MultipartFile getUpload() {
	return upload;
}
public void setUpload(MultipartFile upload) {
	this.upload=upload;
	if(upload.getOriginalFilename().length()==0) {
		img=upload.getOriginalFilename();
	}
	img = upload.getOriginalFilename();
	
}

}
