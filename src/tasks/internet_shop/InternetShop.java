package homework.internet_shop;


import java.util.*;


public class InternetShop {
    private List<Good> goods; //move to constructor
    private Map<User, List<Good>> basketMap;


    public InternetShop() {
        this.goods = new LinkedList<>();
        this.basketMap = new HashMap<>();

    }

    public void addGoods() {
        goods.add(new Good("qwert", Producer.ACER, Category.SMARTPHONES,
                Subcategory.ACCESSORIES_FOR_SMARTPHONES, 1));
        goods.add(new Good("2222", Producer.ACER, Category.LAPTOPS_AND_COMPUTERS,
                Subcategory.ACCESSORIES_FOR_LAPTOPS_AND_COMPUTERS, 3));
        goods.add(new Good("1111", Producer.SUMSUNG, Category.TV,
                Subcategory.ACCESSORIES_FOR_TV, 2));
        goods.add(new Good("3333", Producer.ACER, Category.SMARTPHONES,
                Subcategory.ACCESSORIES_FOR_SMARTPHONES, 2));
        goods.add(new Good("4444", Producer.ACER, Category.LAPTOPS_AND_COMPUTERS,
                Subcategory.ACCESSORIES_FOR_LAPTOPS_AND_COMPUTERS, 2));
        goods.add(new Good("5666", Producer.HP, Category.LAPTOPS_AND_COMPUTERS,
                Subcategory.ACCESSORIES_FOR_LAPTOPS_AND_COMPUTERS, 2));
        goods.add(new Good("7777", Producer.ACER, Category.LAPTOPS_AND_COMPUTERS,
                Subcategory.ACCESSORIES_FOR_LAPTOPS_AND_COMPUTERS, 2));
        goods.add(new Good("8888", Producer.HP, Category.LAPTOPS_AND_COMPUTERS,
                Subcategory.ACCESSORIES_FOR_LAPTOPS_AND_COMPUTERS, 2));

    }


    public void removeGood(Category category) {
        goods.removeIf(good -> good.getCategory().equals(category));
    }

    public Good searchGood(String name, Good searchedGood) {

        for (Good good : goods)
            if (name.equals(good.getNameOfGood())) {
                searchedGood = good;
            }
        return searchedGood;
    }


    public void searchCategory(Category category) {
        for (Good good : goods) {
            if (good.getCategory() == category) {
                System.out.println(good.toString());
            }
        }
    }

    public void addOtherGoods(Good addedGood) {
        goods.add(addedGood);
        for (Good good : goods) {
            if (good.getNameOfGood().equals(addedGood.getNameOfGood())) {
                int quantityOfGood = good.getAmount();
                int quantityOfNewGood = addedGood.getAmount();
                good.setAmount(good.getAmount() + addedGood.getAmount());
                goods.remove(addedGood);

            }
        }
    }


    public void getFullBasket(User user, Basket basket) {
        basketMap.put(user, basket.getBasket());

        for (Map.Entry<User, List<Good>> item : basketMap.entrySet()) {
            System.out.println(item.getKey().getLogin() + "\n" + item.getValue());
        }
    }


    public void printList() {
        for (Good good : goods) {
            System.out.println(good.toString());
        }
    }

}
