package homework.PolymorphismSoftServe;

public class Circle extends Shape {

    @Override
    public void drawShape() {
        ShareType shareType = ShareType.CIRCLE;
        System.out.println(shareType);
    }
}
