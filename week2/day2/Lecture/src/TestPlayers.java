
public class TestPlayers {

	public static void main(String[] args) {
		Human joe = new Human("Joe");
		Warrior w1 = new Warrior("Gorlock");
//		System.out.println(w1.getLevel());
//		w1.dodge();
//		System.out.println(w1.getStamina());
//		w1.rest();
//		System.out.println(w1.getStamina());
//		joe.attack(w1);
		w1.grappleHook();
		w1.dodge();
		joe.dodge();
//		System.out.println(joe.getStamina());
		System.out.println(w1.getStamina());
		System.out.println(joe.getStamina());
//		System.out.println(joe.getLevel());
	}

}
