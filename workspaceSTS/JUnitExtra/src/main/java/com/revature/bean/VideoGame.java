package com.revature.bean;

public class VideoGame {
	String name;
	String genre;
	int metascore;
	
	public VideoGame(String name, String genre, int metascore) {
		super();
		this.name = name;
		this.genre = genre;
		this.metascore = metascore;
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
	public int getMetascore() {
		return metascore;
	}
	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}
	
	
	
}
