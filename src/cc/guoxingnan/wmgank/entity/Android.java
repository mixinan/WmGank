package cc.guoxingnan.wmgank.entity;

public class Android {
	String time;
	String from;
	String url;
	String who;
	String desc;
	
	public Android() {
		super();
	}
	public Android(String time, String from, String url, String who, String desc) {
		super();
		this.time = time;
		this.from = from;
		this.url = url;
		this.who = who;
		this.desc = desc;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
