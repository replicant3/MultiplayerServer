
public class Champion {
	private CooldownTimer [] cdt = new CooldownTimer [4];
	
	
	public Champion(long cdt[]) {
		for(int i = 0; i < 4; i++) {
			this.cdt[i] = new CooldownTimer(cdt[i]);
		}
	}
	
	public void abilityQ() {
		cdt[0].getOnCooldown();
	}
	
	public void abilityW() {
		cdt[1].getOnCooldown();
	}
	
	public void abilityE() {
		cdt[2].getOnCooldown();
	}
	
	public void abilityR() {
		cdt[3].getOnCooldown();
	}
}
