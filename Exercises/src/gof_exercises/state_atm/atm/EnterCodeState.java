package exercises.gof_exercises.state_atm.atm;

public class EnterCodeState implements AtmState {
	private Atm atm;
	private int tries = 0;
	
	public EnterCodeState(Atm atm) {
		this.atm = atm;
	}
	
	@Override
	public void enterCard() {
		System.out.println("Invalid state");
	}
	
	@Override
	public void enterCode() {
		if (validCode()) {
			System.out.println("Entering Code :)");
			atm.setState(new EnterWithdrawalState(atm));
		} else {
			if (tries < 5) {
				tries++;
				System.out.println("Invalid Code, please try again");
			} else {
				System.out.println("Too many failed attempts");
			}
		}
	}
	
	@Override
	public void enterWithdrawal() {
		System.out.println("Invalid state");
	}
	
	@Override
	public void takeMoney() {
		System.out.println("Invalid state");
	}
	
	private boolean validCode() { return true;}
}
