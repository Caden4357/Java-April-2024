
public class Warrior extends Human implements Actionable{

	
	
	public Warrior(String name) {
		super(name);
		this.setLevel(10);
	}
	
	@Override
	public void dodge() {
		this.setStamina(this.getStamina() - 5);
	}
	@Override
	public void attack(Human playerBeingAttacked) {
		this.setStamina(this.getStamina() - 10);
		playerBeingAttacked.setHealth(playerBeingAttacked.getHealth() - 20);
	}
	
	
	public void grappleHook() {
		this.setStamina(this.getStamina() - 15);
	}

	

}
