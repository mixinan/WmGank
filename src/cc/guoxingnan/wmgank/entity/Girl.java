package cc.guoxingnan.wmgank.entity;

import java.io.Serializable;

public class Girl implements Serializable{
	/**
	 * 系统自动生成的常量
	 */
	private static final long serialVersionUID = 8654975303918287078L;
	private String who;
	private String url;
	private String createdAt;
	
	public Girl() {
		super();
	}
	public Girl(String who, String url,String createdAt) {
		super();
		this.who = who;
		this.url = url;
		this.createdAt = createdAt;
	}
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	

	public void updateBackground(String respText) {
		setUrl(this.url.replaceFirst("images/\\w+.png", respText));
	}
}
