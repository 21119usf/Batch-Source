package com.revature.service;

import com.revature.bean.VideoGame;

public class VGService {
/*crud methods
	create
	read
	update
	delete
	*/
	
	public VideoGame createGame(String name, String genre, int metaScore) {
		VideoGame vg = new VideoGame(name, genre, metaScore);
		return vg;
		
	}
	public void rateGame(int a, VideoGame vg){
		vg.setMetaScore(vg.getMetaScore()+a);
	}
}
