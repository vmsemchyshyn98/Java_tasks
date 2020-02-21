package homework.PolymorphismSoftServe;

public class Square extends Shape {


    @Override
    public void drawShape() {
        ShareType shareType = ShareType.SQUARE;
        System.out.println(shareType);
    }
}
