import java.util.ArrayList;

public class Weapon implements Equippable {
	private String name;
	private String weaponType;
	private int attackPower;
	private ArrayList<String> equipHistory = new ArrayList<>(); // ['Gorlock equiped sword', 'Gorlock unequiped sword']
	
	public Weapon(String name, String weaponType, int attackPower) {
		this.name = name;
		this.weaponType = weaponType;
		this.attackPower = attackPower;
	}

	public void equip(Human character) {
		character.setEquipWeapon(this);
		this.equipHistory.add(character.getName() + " Equiped " + this.name);
	}
	
	public void unequip(Human character) {
		if(character.getEquipWeapon() == this) {
			character.setEquipWeapon(null);
			this.equipHistory.add(character.getName() + " Unequiped " + this.name);
		}
	}
	 public ArrayList<String> equipmentHistory(){
		 return equipHistory;
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

	public ArrayList<String> getEquipHistory() {
		return equipHistory;
	}

	public void setEquipHistory(ArrayList<String> equipHistory) {
		this.equipHistory = equipHistory;
	}
	
	
}
