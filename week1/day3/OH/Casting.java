package week1.day3.OH;
import java.lang.Math;
public class Casting {

    public static void main(String[] args) {
        // implicit casting
        // Implicit Casting (Widening):
        // Implicit casting occurs when converting a smaller data type to a larger data
        // Java automatically performs implicit casting without the need for explicit
        // syntax, as it involves no loss of data.
        // For example, converting an int to a double is an implicit cast because a
        // double can hold a wider range of values than an int.
        int myInt = 9;
        double myDouble = myInt;
        System.out.println(myInt);
        System.out.println(myDouble);

        // explicit casting
        // Explicit Casting (Narrowing):
        // Explicit casting occurs when converting a larger data type to a smaller data
        // type.
        // Since this process can potentially result in data loss or truncation,
        // explicit casting requires manual intervention.
        // To perform explicit casting, we use syntax (dataType) value, where dataType
        // is the target data type, and value is the value to be cast.
        // For example, converting a double to an int requires explicit casting because
        // an int cannot hold decimal values.
        double myDouble2 = 9.78;
        System.out.println(Math.ceil(myDouble2));
        int myInt2 = (int) myDouble2;
        System.out.println(myDouble2);
        System.out.println(myInt2);
    }
}
