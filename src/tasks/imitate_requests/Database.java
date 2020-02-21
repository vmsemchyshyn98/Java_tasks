package homework.imitate_requests;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Database {
    private ArrayList<Man> database;
    private ArrayList<Adress> adresses;

    public Database() {
        this.database = new ArrayList<>();
    }

    public void addPeople() {
        database.add(new Man("Tom", "Box", 36, 2,
                new Adress("USA", "New York", "aaaaaa str")));
        database.add(new Man("Ben", "Addd", 23, 0,
                new Adress("USA", "Washington", "ssssss str")));
        database.add(new Man("Jack", "Tent", 45, 3,
                new Adress("German", "Berlin", "bbbbbb str")));
        database.add(new Man("Jack", "Tent", 45, 3,
                new Adress("German", "Berlin", "bbbbbb str")));
        database.add(new Man("John", "Clock", 24, 3,
                new Adress("USA", "New York", "ggggg str")));
        database.add(new Man("Sem", "Weeei", 51, 3,
                new Adress("France", "Paris", "ppppp str")));
        database.add(new Man("Tom", "Box", 36, 2,
                new Adress("USA", "New York", "aaaaaa str")));
        database.add(new Man("Tom", "Box", 36, 2,
                new Adress("USA", "New York", "aaaaaa str")));
        database.add(new Man("Tom", "Box", 36, 2,
                new Adress("USA", "New York", "aaaaaa str")));

        database.addAll(Arrays.asList(new Man("Tom", "Box", 36, 2,
                        new Adress("USA", "New York", "aaaaaa str")),
                new Man("Ben", "Addd", 23, 0,
                        new Adress("USA", "Washington", "ssssss str"))));

    }

    public void selectAllMan() {
        System.out.println("SELECT * FROM Man");
        database.stream().forEach(man -> System.out.println(man.toString()));
    }

    public void selectAllAdress() {
        System.out.println("SELECT * FROM Adress");
        database.forEach(man -> System.out.println(man.getAdress()));
    }


    public void filterByAgeAndSortByFirstName() {

        System.out.println("SELECT * firstName, lastName, countOfChildren FROM Man WHERE age >= 20 ORDER BY firstName");

        Consumer<Person> consumer = person -> System.out.println(person.getFirstName() + "  " +
                person.getLastName() + "  " + person.getCountOfChildren());
        Comparator<Person> comparator = (o1, o2) -> (o1.getFirstName().compareTo(o2.getFirstName()));

        Function<Man, Person> function = man -> new Person(man.getFirstName(), man.getLastName(),
                man.getCountOfChildren());


        database.stream().filter(man -> man.getAge() >= 37).map(function)
                .sorted(comparator).collect(Collectors.toList()).forEach(consumer);

    }


    public void updateInformation() {
        System.out.println("UPDATE Man SET firstName = 'John', lastName = 'Kennedi', countOfChildren = 3" +
                " WHERE country == 'US' (or another country)");

        Predicate<Man> predicate = man -> (man.getAdress().getCountry().equals("France"));
        Consumer<Man> consumer = (man) -> {
            man.setFirstName("John");
            man.setLastName("Kennedi");
            man.setCountOfChildren(3);
            System.out.println(man.getFirstName());
            System.out.println(man.getLastName());
            System.out.println(man.getCountOfChildren());
        };
        database.stream().filter(predicate).forEach(consumer);


    }

    public void filterByCountryAndStreet() {
        System.out.println("SELECT * firstName, lastName, nameOfStreet FROM Man WHERE country == 'Canada' AND " +
                "numberOfHome == 3 OR age >= 25");
        Predicate<Man> predicate = man -> {
            Adress address = man.getAdress();

            return address.getCountry().equals("German") &&
                    address.getStreet().equals("bbbbbb str");
        };

        Function<Man, Person> function = man -> new Person(man.getFirstName(), man.getLastName(), man.getAdress().getStreet());

        Predicate<Man> secondPredicate = man -> man.getAge() >= 25;

        Consumer<Person> print = man -> System.out.println(man.getFirstName() + "  " +
                man.getLastName() + "  " + man.getAdress().getStreet());//?????????????????????????????????

        Consumer<Person> consumer = man -> System.out.println(man.getFirstName() + "  " +
                man.getLastName());

        List<Man> manList = database.stream().filter(predicate.or(secondPredicate)).collect(Collectors.toList());

        manList.stream().map(function).forEach(print);

        // people.stream().map(function).collect(Collectors.toList()).forEach(print);
    }/////////////////////?????????????

    public void groupByCountOfChildren() {
        System.out.println("SELECT * count FROM Man GROUP BY countOfChildren");

        database.stream().
                collect(Collectors.groupingBy(Man::getCountOfChildren, counting()))
                .forEach((key, value) -> System.out.println("Key:" + key + "  Value:" + value));

    }

    public void groupByCountOfChildrenAndAge() {
        System.out.println("SELECT * count FROM Man GROUP BY countOfChildren, age");


        database.stream()
                .collect(Collectors.groupingBy(man -> new AbstractMap.SimpleEntry<>(man.getCountOfChildren(), man.getAge()),
                        counting())).forEach((key, value) -> System.out.println("Key:" + key + "  Value:" + value));


    }



    public void groupByCityAndNameOfStreet() {//refactor
        System.out.println("SELECT * count FROM Man GROUP BY city, nameOfStreet");

        database.stream().collect(Collectors.groupingBy(man -> new AbstractMap.SimpleEntry<>(
                man.getAdress().getTown(), man.getAdress().getStreet()), counting())).
                forEach((key, value) -> System.out.println("Key:" + key + "  Value:" + value));


    }

    public void groupByCityAndNameOfStreetHavingCountOfCitizens() {//refactor
        System.out.println("SELECT * count FROM Man GROUP BY city, nameOfStreet HAVING countOfCitizens > 4");
        Predicate<Man> predicate = man -> man.getCountOfChildren() > 1;


        database.stream()
                .collect(Collectors.groupingBy(man -> new AbstractMap.SimpleEntry<>(man.getAdress().getTown(),
                        man.getAdress().getStreet()), counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 4).forEach((value) -> System.out.println("Value:" + value));
        ;


    }


    public void groupByCityAndNameOfStreetFromAdress() {

        System.out.println("SELECT * count FROM Adress GROUP BY city, nameOfStreet HAVING countOfCitizens > 4");
        Function<Man, Adress> function = adress -> new Adress(adress.getAdress().getCountry(), adress.getAdress().getTown(),
                adress.getAdress().getStreet());

        List<Adress> adresses = database.stream().map(function).collect(Collectors.toList());
        adresses.stream().collect(Collectors.groupingBy(adress -> new AbstractMap.SimpleEntry<>(adress.getTown(),
                adress.getStreet()), counting())).entrySet().stream().filter(entry -> entry.getValue() > 4)
                .forEach(value -> System.out.println("Value: " + value));

    }

    public void groupByCityAndNameOfStreetHavingCountOfCitizensFromAdress() {
        System.out.println("SELECT * count FROM Adress GROUP BY city, nameOfStreet");
        Function<Man, Adress> function = adress -> new Adress(adress.getAdress().getCountry(), adress.getAdress().getTown(),
                adress.getAdress().getStreet());

        List<Adress> adresses = database.stream().map(function).collect(Collectors.toList());

        adresses.stream().collect(Collectors.groupingBy(adress -> new AbstractMap.SimpleEntry<>(
                adress.getTown(), adress.getStreet()), counting())).
                forEach((key, value) -> System.out.println("Key:" + key + "  Value:" + value));

    }

}


