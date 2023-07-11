package org.example.model;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Having a bad day...";
	}
	
}
