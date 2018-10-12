package Behaviour;

public class FreezeBehaviour extends Behaviour {
	private static FreezeBehaviour INSTANCE;
	
	public static FreezeBehaviour getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new FreezeBehaviour();
		}
		return INSTANCE;
	}
	
}
