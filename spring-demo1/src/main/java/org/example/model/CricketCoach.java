package org.example.model;

public class CricketCoach implements Coach{

	private FortuneService fortuneService;
	
//	public CricketCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "practice spin bowling today..";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
