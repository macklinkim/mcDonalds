package emac.entity;

import java.util.Date;

public class CommEntity {
	private int rno;
	private int bno;
	private String content;
	private Date wdate;
	private String mid;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public CommEntity(int rno, int bno, String content, Date wdate, String mid) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.content = content;
		this.wdate = wdate;
		this.mid = mid;
	}
	public CommEntity(int bno, String id, String content) {
		this.bno = bno;
		this.content = content;
		this.wdate = new Date();
		this.mid = id;
	}
	
}
