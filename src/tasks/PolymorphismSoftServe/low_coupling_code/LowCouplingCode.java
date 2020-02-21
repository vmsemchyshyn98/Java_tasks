package homework.PolymorphismSoftServe.low_coupling_code;

public class LowCouplingCode {
    private One one;
    private Two two;

    public LowCouplingCode(One one, Two two) {
        this.one = one;
        this.two = two;
    }

    public void executeOne() {
        one.print();
    }

    public void executeTwo() {
        one.print();
    }
}

interface Printable {
    void print();
}

class LowCouplingCodeRefactor {
    private Printable printable;

    public LowCouplingCodeRefactor(Printable printable) {
        this.printable = printable;
    }

    public void execute() {
        printable.print();
    }
}

class One implements Printable {
    public void print() {
        System.out.println("One");
    }
}

class Two implements Printable {
    public void print() {
        System.out.println("Two");
    }
}

class Main {
    public static void main(String[] args) {

        Printable one = new One();

        Printable two = new Two();

        new LowCouplingCodeRefactor(one);

        new LowCouplingCodeRefactor(two);
    }
}

