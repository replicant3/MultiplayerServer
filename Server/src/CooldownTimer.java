public class CooldownTimer {
	long lastAttack = 0;
	long cooldownTime;
	
	public CooldownTimer(long cooldownTime){
		this.cooldownTime = cooldownTime;
	}
	
	/**
	 * return true if ability is on cooldown else returns false.
	 * @return
	 */
	public boolean getOnCooldown() {
		long time = System.currentTimeMillis();
		if(time > lastAttack + cooldownTime) {
			System.out.println("Ability");
			lastAttack = time;
			return false;
		}
		System.out.println("Cooldown" + ((lastAttack + cooldownTime) - time));
		return true;
	}
}