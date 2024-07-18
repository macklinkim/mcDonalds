package emac.entity;

import java.util.Date;

public class BoardEntity {
	private int no;
	private String id;
	private Date wdate;
	private String title;
	private String content;
	private int reply;
	private int count;
	private int deleted;
	
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public BoardEntity(int no,String id, Date wdate, String title, String content,
			int reply, int count) {
		super();
		this.no = no;
		this.id=id;
		this.wdate = wdate;
		this.title = title;
		this.content = content;
		this.reply = reply;
		this.count = count;
	}
	public BoardEntity(String title, String content, String writer) {
		this.id=writer;
		this.wdate = new Date();
		this.title = title;
		this.content = content;
		this.reply = 0;
		this.count = 0;
	}
	public BoardEntity(int no, String writer, Date wdate,
			String title, String content, int reply, int count, int deleted) {
		this.no = no;
		this.id=writer;
		this.wdate = wdate;
		this.title = title;
		this.content = content;
		this.reply = reply;
		this.count = count;
		this.deleted= deleted;
	}
	public BoardEntity() {
	}
	public BoardEntity(int no, String writer, String title, String contents,Date wdate, int replycnt, int readcnt) {
		this.no = no;
		this.id = writer;
		this.title = title;
		this.content = contents;
		this.wdate = wdate;
		this.reply = replycnt;
		this.count = readcnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
