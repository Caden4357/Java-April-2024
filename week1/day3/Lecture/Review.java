package week1.day3.Lecture;
import java.util.ArrayList;
public class Review {
    public static void main(String[] args) {
        // Primitive DataTypes
        int age = 25;
        boolean isHuman = true;
        char a = 'a';
        double pi = 3.14;
        long bigNum = 123;
        short num = 1;

        // Wrapper Classes
        String name = "Shane";
        Integer time = 4;
        Double dec = 2.32;
        Boolean climbedMountain = false;
        Character bigChar = 'A';

        // data structures
        // fixedArrays
        int[] arr1 = new int[5];
        arr1[0] = 4;
        arr1[1] = 8;
        arr1[2] = 8;
        arr1[3] = 5;
        arr1[4] = 9;
        int[] arr2 = { 1, 2, 3, 4, 5 };

        // arraylists 
        ArrayList<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("Spanish");
        languages.add("HTML");

        // access an item 
        System.out.println(languages.get(1));

        // loops 
        System.out.println("---------------------Loop from 1 - 10------------------");

        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }

        System.out.println("---------------------Loop over array------------------");
        
        // looping over arrays and hashmaps 
        // arrays 
        for(int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i]);
        }

        for(int i = 0; i < languages.size(); i++){
            System.out.println(languages.get(i));
        }

    }
}
