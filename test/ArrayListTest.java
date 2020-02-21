import homework.create_array_list.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class ArrayListTest {

    private ArrayList list = new ArrayList();

    @Before
    public void clearArray() {
        list.setArray(new int[3]);
    }

    @Test
    public void shouldAddElementToArray() {
        list.addElement(5);
        list.addElement(1);
        list.addElement(3);

        int[] array = list.getArray();

        Assert.assertEquals("", 5, array[0]);
        Assert.assertEquals("", 1, array[1]);
        Assert.assertEquals(3,array.length);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowArrayIndexOutOfBoundsException() {

        list.changeNumberInArray(3, 11);

    }

    @Test
    public void shouldChangeElementByIndex() {
        list.changeNumberInArray(1, 5);

        int[] array = list.getArray();

        Assert.assertEquals(5, array[1]);

        Assert.assertEquals(0, array[0]);
    }


    @Test
    public void shouldDeleteElementByIndex() {

        list.addElement(2);
        list.addElement(9);
        list.addElement(4);
        list.addElement(1);

        list.deleteNumberInArray(0);

        int[] array = list.getArray();

        Assert.assertEquals(9, array[0]);
        Assert.assertEquals(4, array.length);
    }


    @Test
    public void shouldAddSomeElements() {

        list.increaseArray(3);

        int[] array = list.getArray();



        Assert.assertEquals(0, array[array.length - 3]);
        Assert.assertEquals(0, array[array.length - 1]);
        Assert.assertEquals(0, array[array.length - 2]);
        Assert.assertEquals(6,array.length);


    }

    @Test
    public void shouldReadOnOppositeSide() {

        list.readOnOppositeSide();

        int[] array = list.getArray();

        int arrayLength = array.length;

        Assert.assertEquals(11, array[0]);
        Assert.assertEquals(34, array[arrayLength - 1]);

    }


    @Test
    public void shouldSortElements() {
        list.bubbleSort();

        int[] array = list.getArray();

        Assert.assertEquals(1, array[0]);
        Assert.assertEquals(68, array[array.length - 1]);
    }


    @Test
    public void shouldDeleteDuplicates() {
        list.deleteDuplicates();
        int[] array = list.getArray();

        Assert.assertEquals(11, array[0]);

        Assert.assertEquals(0, array[array.length - 1]);

        //check length

    }


    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Test
    public void shouldSearchElement() {

        list.addElement(1);
        list.addElement(21);
        list.addElement(8);
        list.addElement(3);
        list.searchElementByIndex(2);

        String number = outRule.getLog();

        Assert.assertTrue(number.contains("Value:8"));

    }

}
