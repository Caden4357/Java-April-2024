
public class TestOrders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ITEMS
		Item item1 = new Item();
		item1.name = "Mocha";
		item1.price = 3.5;
		
		Item item2 = new Item();
		item2.name = "Drip coffee";
		item2.price = 2.5;
		
		Item item3 = new Item();
		item3.name = "Latte";
		item3.price = 4.5;
		
		Item item4 = new Item();
		item4.name = "Cappuccino.";
		item4.price = 5.5;
		
//		ORDERS 
		Order order1 = new Order();
		order1.name = "Cindhuri";
		Order order2 = new Order();
		order2.name = "Jimmy";
		Order order3 = new Order();
		order3.name = "Noah";
		Order order4 = new Order();
		order4.name = "Sam";
		System.out.println(order1.total); // prediction: null 
		
//		add item1 to order2s itemList
		order2.items.add(item1);
//		increment order2s total by item1s price
		order2.total += item1.price;
		
		
//		add cap to noahs order list 
		order3.items.add(item4);
		order3.total += item4.price;
		
		System.out.println(order3.items);
		System.out.println(order3.total);
		
		order1.isReady = true;
		System.out.println(order1.isReady);
		
		
		
		
		

	}

}
