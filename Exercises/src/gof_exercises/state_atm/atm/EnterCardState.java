package exercises.gof_exercises.state_atm.atm;

public class EnterCardState implements AtmState {
	private Atm atm;
	
	public EnterCardState(Atm atm) {
		this.atm = atm;
	}
	
	@Override
	public void enterCard() {
		System.out.println("Entering Card :)");
		atm.setState(new EnterCodeState(atm));
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
		System.out.println("Invalid state");
	}
}
