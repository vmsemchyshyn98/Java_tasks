package homework.create_array_list;

import java.util.Random;


public class ArrayList {

    private int[] array;

    public ArrayList() {
        array = new int[1];//0, resize
    }

    //TODO Only for tests purpose
    public int[] getArray() {
        return array;
    }

    //TODO Only for tests purpose
    public void setArray(int[] array) {
        this.array = array;
    }

    public void addElement(int value) {

        resize();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = value;
                break;
            }

        }
    }

    private void resize() {
        int countZeros = 0;

        for (int elem : array) {
            if (elem == 0) {
                countZeros++;
            }
        }

        if (countZeros == 0) {
            int[] temp = new int[array.length + 2];

            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }

            array = temp;
        }


    }


    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }



    public void deleteNumberInArray(int index) {
        int[] temp = new int[array.length - 1];

        for (int i1 = 0; i1 < index; i1++) {
            temp[i1] = array[i1];
        }

        for (int i1 = index; i1 < array.length - 1; i1++) {
            temp[i1] = array[i1 + 1];
        }

        array = temp;

    }


    public void changeNumberInArray(int index, int value) {
        //check index is valid
        if (index < 0 || index > array.length || value == 0) {
            throw new ArrayIndexOutOfBoundsException("Index is incorrect or value = 0");
        }
        array[index] = value;
    }

    public void increaseArray(int amount) {
        int[] newArray = new int[array.length + amount];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = new int[newArray.length];

        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }


    public void readOnOppositeSide() {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }


    public void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
    }


    public void addArrayToArray(int[] addedArray) {
        int[] newArray = new int[array.length + addedArray.length];

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                newArray[i] = array[i];
                count++;
            }

        }

        for (int j = 0; j < addedArray.length; j++) {
            newArray[count + j] = addedArray[j];
        }

        array = new int[newArray.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }


    public void deleteDuplicates() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] != 0 && array[i] == array[j]) {
                    deleteNumberInArray(j);
                }
            }
        }

    }


    public void searchElementByIndex(int index) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[index]) {
                System.out.println("Value:" + array[index]);
            }
        }
    }


    public void mixArray() {
        Random in = new Random();

        int k = in.nextInt(array.length - 1);
        for (int i = 0; i < array.length; i++) {
            int t = array[i];
            array[i] = array[k];
            array[k] = t;
        }

    }


    public static void main(String[] args) {

        int[] arr2 = new int[]{22, 9, 4};

        ArrayList arrayList = new ArrayList();
        arrayList.addElement(4);
        arrayList.addElement(2);
        arrayList.addElement(7);
        arrayList.addElement(7);
        arrayList.addElement(5);
        arrayList.addElement(2);
        arrayList.addElement(1);
       arrayList.addArrayToArray(arr2);
       arrayList.deleteDuplicates();



        arrayList.print();
        System.out.println();
        System.out.println(arrayList.array.length);

        arrayList.searchElementByIndex(2);


    }


}
