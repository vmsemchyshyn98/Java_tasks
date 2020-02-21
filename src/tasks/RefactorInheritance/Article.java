package homework.RefactorInheritance;

public class Article extends Reference {
    private int startPage;
    private int endPage;
    private String nameArticle;


    Article(String author1, String author2, String author3, String author4, Boolean isUpdated, int year, int volume,
            int startPage, int endPage, String nameArticle) {
        super(author1, author2, author3, author4, isUpdated, year, volume);
        this.startPage = startPage;
        this.endPage = endPage;
        this.nameArticle = nameArticle;
    }


    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    @Override
    public void processing() {
        super.processing();
        System.out.println("8)" + startPage);
        System.out.println("9)" + endPage);
        System.out.println("10)" + nameArticle);
    }
}
