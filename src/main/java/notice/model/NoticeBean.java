package notice.model;

import java.sql.Timestamp;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class NoticeBean {

	private int num;
	
	@NotBlank(message="작성자는 필수입니다")
	private String writer;
	
	@Size(min=1, max=30, message="1~30자 사이로 제목 입력하세요.")
	private String subject;
	
	//@Size(min=1, max=300, message="1~300자 사이로 내용 입력하세요.")
	//@Length(min=1, max=300, message="1~300자 내로 내용 입력하세요.")
	@NotEmpty(message="내용 입력 누락")
	private String content;
	
	private Timestamp regdate;
	private int readcount;
	private int ref;
	private int restep;
	private int relevel;
	
	//@NotEmpty(message = "화일 선택 필수")
	private String image;
	
	
	private MultipartFile upload;
	public MultipartFile getUpload() {
		return upload;
	}
	
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		image = upload.getOriginalFilename();
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Size(min=1, max=50, message="1~50자 사이로 제목 입력하세요.")
	private String reply;
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	
	
	
	public NoticeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticeBean(int num, String writer, String subject, String content, Timestamp regdate, int readcount, int ref,
			int restep, int relevel,String image, MultipartFile upload, String reply) {
		super();
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.readcount = readcount;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
		this.image = image; //String image,MultipartFile upload
		this.upload = upload;
		this.reply = reply;
		
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}

}
