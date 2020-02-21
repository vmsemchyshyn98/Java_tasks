package homework.imitate_requests;

public class Main {
    public static void main(String[] args) {

        Database database=new Database();
        database.addPeople();
        database.selectAllMan();
        database.selectAllAdress();
        database.filterByAgeAndSortByFirstName();

        database.updateInformation();

        database.filterByCountryAndStreet();
        database.groupByCountOfChildren();
        database.groupByCountOfChildrenAndAge();
        database.groupByCityAndNameOfStreet();
        database.groupByCityAndNameOfStreetHavingCountOfCitizens();
        database.groupByCityAndNameOfStreetFromAdress();
        database.groupByCityAndNameOfStreetHavingCountOfCitizensFromAdress();

    }
}
