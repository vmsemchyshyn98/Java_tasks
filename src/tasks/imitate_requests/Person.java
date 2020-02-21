package homework.imitate_requests;

class Person{
    private String firstName;
    private String lastName;
    private int age;
    private int countOfChildren;
    private Adress adress;

    public Person(String firstName, String lastName, int countOfChildren) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countOfChildren = countOfChildren;
    }

    public Person(String firstName, String lastName, String street) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getCountOfChildren() {
        return countOfChildren;
    }

    public Adress getAdress() {
        return adress;
    }
}
