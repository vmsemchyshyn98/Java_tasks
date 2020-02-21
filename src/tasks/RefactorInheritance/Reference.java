package homework.RefactorInheritance;

public class Reference implements Referencable {
    private String author1;
    private String author2;
    private String author3;
    private String author4;
    private Boolean isUpdated;
    private int year;
    private int volume;

    Reference(String author1, String author2, String author3, String author4,
              Boolean isUpdated, int year, int volume) {

        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author2;
        this.author4 = author2;
        this.isUpdated = isUpdated;
        this.year = year;
        this.volume = volume;
    }


    public String getAuthor1() {
        return author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public String getAuthor3() {
        return author3;
    }

    public String getAuthor4() {
        return author4;
    }

    public Boolean getUpdated() {
        return isUpdated;
    }

    public int getYear() {
        return year;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public void processing() {
        System.out.println("1)" + getAuthor1());
        System.out.println("2)" + getAuthor2());
        System.out.println("3)" + getAuthor3());
        System.out.println("4)" + getAuthor4());
        System.out.println("5)" + getUpdated());
        System.out.println("6)" + getYear());
        System.out.println("7)" + getVolume());
    }

}
