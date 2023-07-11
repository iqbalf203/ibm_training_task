package org.example.model;

public class BasketBallCoach implements Coach{
	private FortuneService fortuneService;
	
//	public BasketBallCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "practice nack volley today";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}