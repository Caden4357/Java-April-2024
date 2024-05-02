
public class Weapon {
	private String name;
	private String weaponType;
	private int attackPower;
	private int magicPower; // 0
	
	
	public Weapon(String name, String weaponType, int attackPower) {
		this.name = name;
		this.weaponType = weaponType;
		this.attackPower = attackPower;
	}

	public Weapon(String name, String weaponType, int attackPower, int magicPower) {
		this.name = name;
		this.weaponType = weaponType;
		this.attackPower = attackPower;
		this.magicPower = magicPower;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getWeaponType() {
		return weaponType;
	}


	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}


	public int getAttackPower() {
		return attackPower;
	}


	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}


	public int getMagicPower() {
		return magicPower;
	}


	public void setMagicPower(int magicPower) {
		this.magicPower = magicPower;
	}
	
	
	

	
}
