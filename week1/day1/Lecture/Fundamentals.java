package week1.day1.Lecture;

public class Fundamentals {
    
    public static void main(String[] args) {
        // ? all of your code will go in here for now
        System.out.println("Hello, Caden!");

        // ? Variables/Data Types (Primitives)
        int myAge = 16;
        int favNum;
        favNum = 43;
        boolean isHuman = false;
        double pi = 3.14;
        char x = 'A';
        String name = "Taryn";
        String day = "Monday";

        // Conditionals / if else statements

        // this is saying if isHuman is false with bang operator (!)
        if(!isHuman){
            System.out.println("Alien");
        }
        
        if(myAge > 18){
            System.out.println("Your old enough to enter the club");
        }
        else{
            System.out.println("Maybe next year");
        }

        if(day == "Monday"){
            System.out.println("I hate mondays");
        } 
        else if(day == "Tuesday"){
            System.out.println("1st Lecture Day");
        }
        else{
            System.out.println("I dont know what day that is");
        }

        for(int i = 0; i < 5; i++){
            System.out.println(i);
        }
    }
}
