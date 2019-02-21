package com.revature.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.bean.VideoGame;
import com.revature.service.VGService;

class VGServiceTest {

	@Test
	void createTest() {
		
		ArrayList<VideoGame> gameList= new ArrayList<VideoGame>();
		int before=gameList.size();
		VGService vgs=new VGService();
		gameList.add(vgs.createGame("MGS","Awesome",100));
		int after=gameList.size();
		assertEquals(before+1,after);
	}
	@Test
	void rateTest() {
		VGService vgs=new VGService();
		VideoGame vg= vgs.createGame("MGS","Awesome",100);
		int before= vg.getMetaScore();
		int change= -10;
		vgs.rateGame(change,vg);
		int after=vg.getMetaScore();
		assertEquals(before+change,after);
	}
}
