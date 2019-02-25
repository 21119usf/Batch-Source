package com.revature.bean;

public class VideoGame {
	private String name;
	private String genre;
	private int metaScore;
	public VideoGame() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoGame(String name, String genre, int metaScore) {
		super();
		this.name = name;
		this.genre = genre;
		this.metaScore = metaScore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}
	
}
