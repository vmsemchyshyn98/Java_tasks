package lessons.collection;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;

public class LearnStream {
    public static void main(String[] args) {
        List<Man> men = Arrays.asList(
                new Man("John1", 12, "Lviv", "Velikogo"),
                new Man("John2", 45, "Kiev", "Mazepi"),
                new Man("John3", 26, "Lviv", "Velikogo"),
                new Man("John4", 33, "Dnepr", "Volnaya")
        );

        Predicate<Man> predicate = man -> man.getAge() < 30;

//        List<Man> collect = men.stream().filter(predicate).collect(Collectors.toList());
        men.stream().filter(predicate).forEach(m -> System.out.println(m));

        Function<Man, Person> function = man -> new Person(man.getName(), man.getAge());

        List<Person> people = men.stream().map(function).collect(Collectors.toList());

        boolean b = men.stream().allMatch(man -> man.getAge() == 33);

        Map<Integer, List<Man>> map = men.stream().collect(Collectors.groupingBy(m -> m.getAge() % 2));

        Map<String, Long> map1 = men.stream().collect(Collectors.groupingBy(Man::getCity, counting()));

        class Operation {
            private String city;
            private String street;

            public Operation(String city, String street) {
                this.city = city;
                this.street = street;
            }
        }

        Map<AbstractMap.SimpleEntry<String, String>, Long> map2 = men
                .stream()
                .collect(Collectors.groupingBy(m -> new AbstractMap.SimpleEntry<>(m.getCity(), m.getStreet()),
                        counting()));

        Comparator<Man> comparator = (m1, m2) -> Integer.compare(m1.getAge(), m2.getAge());
        Comparator<Man> comparator2 = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());

        Comparator<Man> comparator1 = Comparator.comparingInt(Man::getAge);

//        System.out.println();

        int sum = men.stream().mapToInt(Man::getAge).sum();

        IntStream.range(0, 100).forEach(System.out::println);

    }
}

class Man {
    private String name;
    private int age;
    private String city;
    private String street;

    public Man(String name, int age, String city, String street) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Person {
    private String firstName;
    private int age;

    public Person(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }
}
