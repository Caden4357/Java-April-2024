
import java.util.ArrayList;
public class TestGreetings {
    public static void main(String[] args) {
        Greetings greet1 = new Greetings(); // invokes a new instance of the greeting class ()
        String greetingCrystal = greet1.sayHello("Crystal");
        System.out.println(greetingCrystal);
        String dateMessage = greet1.getCurrentDate(); // 2
        System.out.println(dateMessage); // 3

        // fixed arrays
        int[] arr1 = new int[5];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[0] = 5;

        int[] arr2 = {1,2,3,4,5,6};
        System.out.println(arr1[0]);
        System.out.println(arr2[2]);
        ArrayList<Integer> myArray = new ArrayList<Integer>();

        ArrayList<String> cars = new ArrayList<String>();

        cars.add("Honda");
        cars.add("BMW");
        cars.add("Volvo");


        myArray.add(1);
        myArray.add(2);
        myArray.add(4);
        myArray.add(3);
        myArray.remove(2);
        System.out.println(cars);
        for(int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i]);
        }
        for(String val: cars){
            System.out.println(val);
        }



    }
}
