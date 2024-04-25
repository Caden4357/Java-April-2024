
import java.util.Date;

public class Greetings {
    
    // constructor

    // class method 
    public String sayHello(String name){
        return "Hello " + name;
    }
    public String getCurrentDate() {
        Date date = new Date();
        return "Current date is: " + date;
    }

}
