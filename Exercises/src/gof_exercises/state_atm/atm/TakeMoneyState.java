package exercises.gof_exercises.state_atm.atm;

public class TakeMoneyState implements AtmState {
	private Atm atm;
	
	public TakeMoneyState(Atm atm) {
		this.atm = atm;
	}
	
	@Override
	public void enterCard() {
		System.out.println("Invalid state");
	}
	
	@Override
	public void enterCode() {
		System.out.println("Invalid state");
	}
	
	@Override
	public void enterWithdrawal() {
		System.out.println("Invalid state");
	}
	
	@Override
	public void takeMoney() {
		System.out.println("Taking Money :)");
		atm.setState(new EnterCardState(atm));
	}
}
