package homework.RefactorInheritance;

public class Book extends Reference {

    private int countOfpages;
    private String nameBook;

    Book(String author1, String author2, String author3, String author4, Boolean isUpdated, int year, int volume,
         int countOfpages, String nameBook) {
        super(author1, author2, author3, author4, isUpdated, year, volume);
        this.countOfpages = countOfpages;
        this.nameBook = nameBook;
    }


    public int getCountOfpages() {
        return countOfpages;
    }

    public String getNameBook() {
        return nameBook;
    }


    @Override
    public void processing() {
        super.processing();
        System.out.println("8)" + countOfpages);
        System.out.println("9)" + nameBook);
    }
}
