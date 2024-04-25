
public class Warrior extends Human {
	
	
	public Warrior(String name) {
		super(name);
		this.setLevel(10);
	}
	
	public void dodge() {
		this.setStamina(this.getStamina() - 5);
	}
	
	public void grappleHook() {
		this.setStamina(this.getStamina() - 15);
	}

}
