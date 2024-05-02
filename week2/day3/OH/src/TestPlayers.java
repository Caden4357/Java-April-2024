
public class TestPlayers {

	public static void main(String[] args) {
		Human joe = new Human("Joe");
		Warrior w1 = new Warrior("Snorlock");
		Warrior w2 = new Warrior("Gorlock");
		Weapon straightSword = new BaseWeapon("Straight Sword", "Sword", 5);
		Weapon magicStaff = new MagicWeapon("Magic Staff", "Staff", 6, 8);
		Weapon huntersBow = new BaseWeapon("Hunters Bow", "Bow", 8);
		w1.setEquipedWeapon(magicStaff);
		w2.setEquipedWeapon(huntersBow);
		w1.attack(w2);
		System.out.println(w1.getStamina());
//		w1.dodge();
		System.out.println(w2.getHealth());
//		w1.rest();
//		System.out.println(w1.getStamina());
//		joe.attack(w1);
//		w1.grappleHook();
//		w1.dodge();
//		joe.dodge();
//		System.out.println(joe.getStamina());
//		System.out.println(w1.getStamina());
//		System.out.println(joe.getStamina());
//		System.out.println(joe.getLevel());
	}

}
