package exercises.gof_exercises.state_atm.atm;

public class EnterWithdrawalState implements AtmState {
	private Atm atm;
	
	public EnterWithdrawalState(Atm atm) {
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
		System.out.println("Entering Withdrawal :)");
		atm.setState(new TakeMoneyState(atm));
	}
	
	@Override
	public void takeMoney() {
		System.out.println("Invalid state");
	}
}
