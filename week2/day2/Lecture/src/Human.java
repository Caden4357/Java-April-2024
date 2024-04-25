
public class Human {
	private double health;
	private double stamina;
	private int level;
	private String name;
	private int gold;
	
//	Constructors 
	public Human(String name) {
		this.health = 100;
		this.stamina = 100;
		this.level = 1;
		this.name = name;
	}
	
	
//	Dodge
	public void dodge() {
		this.stamina -= 10;
	}
//	Rest 
	public void rest() {
		stamina += 10;
	}
	
	
	public void attack(Human playerBeingAttacked) {
		this.setStamina(this.getStamina() - 10);
		playerBeingAttacked.setHealth(playerBeingAttacked.getHealth() - 10);
	}
	
	
	
	
	
	
	
//	Getters & Setters 
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getStamina() {
		return stamina;
	}

	public void setStamina(double stamina) {
		this.stamina = stamina;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	
	
	
}
