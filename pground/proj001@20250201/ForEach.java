import java.util.List;
import java.util.ArrayList;

public class ForEach {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Using forEach to print each name
        names.forEach(name -> System.out.println(name));
    }
}
