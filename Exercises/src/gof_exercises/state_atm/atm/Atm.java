package exercises.gof_exercises.state_atm.atm;

public class Atm {
	private AtmState state = new EnterCardState(this);
	
	public void setState(AtmState state) {
		this.state = state;
	}
	
	public void enterCard() {
		state.enterCard();
	}
	
	public void enterCode() {
		state.enterCode();
	}
	
	public void enterWithdrawal() {
		state.enterWithdrawal();
	}
	
	public void takeMoney() {
		state.takeMoney();
	}
}
