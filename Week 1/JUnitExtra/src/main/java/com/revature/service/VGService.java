package com.revature.service;

import com.revature.bean.VideoGame;

public class VGService {
	
//crud methods

		public VideoGame createGame(String name, String genre, int score) {
		VideoGame vg= new VideoGame(name,genre,score);
		return vg;
	}
	public void	rateGame(int a, VideoGame vg){
		vg.setMetaScore(vg.getMetaScore()+a);
	}
}
