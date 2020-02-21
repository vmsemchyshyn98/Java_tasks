package homework.internet_shop;

import java.util.LinkedList;
import java.util.List;

public class Basket {

    private List<Good> basket;


    public Basket() {
        this.basket = new LinkedList<>();
    }

    public List<Good> getBasket() {
        return basket;
    }


    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket +
                '}';
    }

    public List addGoodsToBasket(Good good) {
        if (good.getAmount() > 0) {
            good.setAmount(good.getAmount() - 1);
            basket.add(good);
        } else {
            System.out.println("There are not such goods");
        }

        return basket;
    }





}
