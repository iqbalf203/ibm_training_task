package org.example.model;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Having a good day...";
	}

}
