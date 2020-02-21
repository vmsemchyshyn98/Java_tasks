package homework.internet_shop;

public class Main {
    public static void main(String[] args) {

        InternetShop internetShop = new InternetShop();
        Basket basket = new Basket();
        User user = new User("QWERTY");

        Good good = new Good("8888", Producer.HP, Category.LAPTOPS_AND_COMPUTERS,
                Subcategory.ACCESSORIES_FOR_LAPTOPS_AND_COMPUTERS, 2);

        Good good1=new Good(  "2222", Producer.ACER, Category.LAPTOPS_AND_COMPUTERS,
                Subcategory.ACCESSORIES_FOR_LAPTOPS_AND_COMPUTERS, 3);


        internetShop.addGoods();
        internetShop.addOtherGoods(good);
        internetShop.addOtherGoods(good);

        internetShop.printList();


        System.out.println("Search good: ");
        internetShop.searchCategory(Category.LAPTOPS_AND_COMPUTERS);


        System.out.println("Get Basket");
        basket.addGoodsToBasket(good);
        basket.addGoodsToBasket(good1);
        internetShop.getFullBasket(user,basket);

    }

}
