package homework.imitate_requests;

public class Adress {
    private String country;
    private String town;
    private String street;

    public Adress(String country, String town, String street) {
        this.country = country;
        this.town = town;
        this.street = street;
    }


    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "country='" + country + '\'' +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
