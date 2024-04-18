package week1.day2.OH;

public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 2.40;
        double latte = 4.5;
        double cappuccino = 5.0;
    
        // Customer name variables (add yours below)
        String cindhuri = "Cindhuri";
        String sam = "Sam";
        String jimmy = "Jimmy";
        String noah = "Noah";

    
        // Order completions (add yours below)
        boolean cindurisOrder = false;
        boolean samsOrder = false;
        boolean jimmysOrder = false;
        boolean noahsOrder = true;

    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + cindhuri); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        // System.out.println(sam);
        // if(cindurisOrder){
        //     System.out.println(cindhuri + readyMessage);
        // }else{
        //     System.out.println(cindhuri + pendingMessage);
        // }
        // Cindhuri ordered a coffee. Based on her order status, print the correct status message to the console.
        System.out.println( cindurisOrder ? cindhuri + readyMessage : cindhuri + pendingMessage);
        // Noah ordered a cappucino. Use an if statement to check the status of his order and print the correct status message. If it is ready, also print the message to display the total. Note: Outcomes may be different depending on what you assigned as the status.
        if(noahsOrder){
            System.out.println(generalGreeting + noah + readyMessage + " " + displayTotalMessage + cappuccino);
        }
        else{
            System.out.println(noah + pendingMessage);
        }
        int numberOfLattesOrderedBySam = 2;
        double totalForSam = numberOfLattesOrderedBySam * latte;
        System.out.println(displayTotalMessage + totalForSam);
        if(samsOrder){
            System.out.println(sam + readyMessage);
        }
        else{
            System.out.println(sam + pendingMessage);
        }
    }
}
