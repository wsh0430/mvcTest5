package vo;

import java.util.Date;

public class BoardVo {
	private int idx;
	private String name;
	private String title;
	private String content;
	private String hostIp;
	private int readNum;
	private Date wDate;
	
	public BoardVo() {}
	
	public BoardVo(int idx, String name, String title, String content, String hostIp, int readNum, Date wDate) {
		this.idx = idx;
		this.name = name;
		this.title = title;
		this.content = content;
		this.hostIp = hostIp;
		this.readNum = readNum;
		this.wDate = wDate;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public Date getwDate() {
		return wDate;
	}
	public void setwDate(Date wDate) {
		this.wDate = wDate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", name=" + name + ", title=" + title + ", content=" + content + ", hostIp=" + hostIp
				+ ", readNum=" + readNum + ", wDate=" + wDate + "]";
	}
	
	
}
