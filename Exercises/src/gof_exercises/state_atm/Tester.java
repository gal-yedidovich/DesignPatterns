package exercises.gof_exercises.state_atm;

import exercises.gof_exercises.state_atm.atm.Atm;

public class Tester {
	public static void main(String[] args) {
		Atm atm = new Atm();
		
		//*
		atm.enterCard();
		atm.enterCode();
		atm.enterWithdrawal();
		atm.takeMoney();
		
		/*/
		
		atm.enterCard();
		atm.takeMoney(); //invalid action
		atm.enterCode();
		//*/
	}
}
