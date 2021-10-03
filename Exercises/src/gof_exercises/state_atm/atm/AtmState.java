package exercises.gof_exercises.state_atm.atm;

public interface AtmState {
	void enterCard();
	
	void enterCode();
	
	void enterWithdrawal();
	
	void takeMoney();
}
