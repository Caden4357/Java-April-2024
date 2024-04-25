package week1.day3.Lecture;
import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        // Hashmaps in Java (Objects)
        // ordered in Key value pairs {key:value} instructorObject = {name:'Caden', age:26, isHuman:false}
        // instructorObject[keyName] = 'Caden'
        HashMap<String, String> userMap = new HashMap<String, String>();
        HashMap<String, Object> studentMap = new HashMap<String, Object>();

        userMap.put("name", "Caden");
        userMap.put("age", "26");
        userMap.put("isHuman", "false");
        userMap.replace("age", "27");
        studentMap.put("name", "Jason");
        studentMap.put("age", 26);
        studentMap.put("isHuman", true);

        System.out.println("---------------------TEST START------------------");
        System.out.println(userMap.size());
        System.out.println(userMap); // whats gonna be the output from sysout the whole object
        System.out.println(userMap.get("age"));

        System.out.println("---------------------Loop over student map------------------");

        for(String key: studentMap.keySet()){
            System.out.println(key + ": " + studentMap.get(key));
        }

        System.out.println("---------------------object.containsValue------------------");

        if(userMap.containsValue("Caden")){
            System.out.println("What are you doing here?");
        }
        else{
            System.out.println("Finally a new face");
        }
        

    }
}
