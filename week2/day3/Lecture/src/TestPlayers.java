
public class TestPlayers {

	public static void main(String[] args) {
		Human joe = new Human("Joe");
		Warrior w1 = new Warrior("Gorlock");
		Weapon swordWeapon = new Weapon("Sword", "Sword", 5);
		swordWeapon.equip(w1);
		System.out.println(w1.getEquipWeapon());
		swordWeapon.unequip(w1);
		System.out.println(w1.getEquipWeapon());
		System.out.println(swordWeapon.getEquipHistory());
//		System.out.println(w1.getLevel());
//		w1.dodge();
//		System.out.println(w1.getStamina());
//		w1.rest();
//		System.out.println(w1.getStamina());
		w1.attack(joe);
		w1.grappleHook();
		w1.dodge();
		joe.dodge();
//		System.out.println(joe.getStamina());
		System.out.println(w1.getStamina());
		System.out.println(joe.getHealth());
//		System.out.println(joe.getLevel());
	}

}
