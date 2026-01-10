import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public static boolean isOlderThanLimit(Person p, int ageLimit) {
        return p.age > ageLimit;
    }
}

public class Taskthree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            persons.add(new Person(name, age));
        }

        int ageLimit = sc.nextInt();
        List<String> sortedNames = persons.stream()
                .map(Person::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        List<String> filteredNames = persons.stream()
                .filter(p -> Person.isOlderThanLimit(p, ageLimit))
                .map(Person::getName)
                .collect(Collectors.toList());
        List<String> upperCaseNames = persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(String.join(" ", sortedNames));
        System.out.println(String.join(" ", filteredNames));
        System.out.println(String.join(" ", upperCaseNames));

        sc.close();
    }
}
