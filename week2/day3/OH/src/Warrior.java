
// extends == inherit
public class Warrior extends Human {
	private Weapon equipedWeapon;
	
	public Warrior(String name) {
//		super is calling one of the constructors in the human class this keeping our code DRY
		super(name, 10);
	}
	
	public void attack(Human playerBeingAttacked) {
		int attackPower; // defaulted 0
		if(this.getEquipedWeapon() instanceof MagicWeapon) {
			attackPower = (this.equipedWeapon.getMagicPower() + this.getLevel());
		}else {
			attackPower = (this.equipedWeapon.getAttackPower() + this.getLevel());	
		}
		playerBeingAttacked.setHealth(playerBeingAttacked.getHealth() - attackPower);
		this.setStamina(this.getStamina() - 10);
		System.out.println(this.getName() + " Attacked " + playerBeingAttacked.getName() + " and did " + attackPower + " damage");
	}
	
	public void dodge() {
		this.setStamina(this.getStamina() - 5);
	}
	
	public void grappleHook() {
		this.setStamina(this.getStamina() - 15);
	}

	public Weapon getEquipedWeapon() {
		return equipedWeapon;
	}

	public void setEquipedWeapon(Weapon equipedWeapon) {
		this.equipedWeapon = equipedWeapon;
	}

}
