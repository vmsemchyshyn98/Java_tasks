package homework.RefactorInheritance;

public class Main {

    public static void main(String[] args) {

        Book book = new Book("aa", "bb", "cc", "dd", true,
                2, 1, 10, "rrr");
        book.processing();
        System.out.println();
        Article article = new Article("zz", "xx", "vv", "ss", true,
                2, 1, 2, 15, "kkk");
        article.processing();
    }
}
