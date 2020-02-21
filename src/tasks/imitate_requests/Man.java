package homework.imitate_requests;

public class Man {
    private String firstName;
    private String lastName;
    private int age;
    private int countOfChildren;
    private Adress adress;

    public Man(String firstName, String lastName, int age, int countOfChildren, Adress adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.countOfChildren = countOfChildren;
        this.adress = adress;
    }




    public Adress getAdress() {
        return adress;
    }

    public int getAge() {
        return age;
    }

    public int getCountOfChildren() {
        return countOfChildren;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountOfChildren(int countOfChildren) {
        this.countOfChildren = countOfChildren;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Man{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", countOfChildren=" + countOfChildren +
                ", adress=" + adress +
                '}';
    }





 /*   public static void main(String[] args) {
      //  ArrayList<Man> men = new ArrayList<>();







        System.out.println("UPDATE Man SET firstName = 'John', lastName = 'Kennedi', countOfChildren = 3 WHERE country == 'US' (or another country)");


    }*/
}

