package homework.internet_shop;

public class Good {

    private String nameOfGood;
    private Producer producer;
    private Category category;
    private Subcategory subcategory;
    private int amount;


    public Good(String nameOfGood, Producer producer, Category category, Subcategory subCategory, int amount) {

        this.nameOfGood = nameOfGood;
        this.producer = producer;
        this.category = category;
        this.subcategory = subCategory;
        this.amount = amount;
    }

    public String getNameOfGood() {
        return nameOfGood;
    }

    public Category getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Good{" +
                "nameOfGood='" + nameOfGood + '\'' +
                ", producer=" + producer +
                ", category=" + category +
                ", subcategory=" + subcategory +
                ", amount=" + amount +
                '}';
    }
}


/*
 * producer - ENUM
 * Nokia 1100, HeadPhone for 1100
 * Category - PHONE, TV, FISHING, SubCategory - PHONE
 * Category - PHONE, SubCategory - HEADPHONE
 * */