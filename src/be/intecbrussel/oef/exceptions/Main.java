package be.intecbrussel.oef.exceptions;

public class Main {
    public static void main(String[] args) {

        check(90);

    }
    public static void check (Integer km) throws ArithmeticException {

        if (km > 80) {

            throw new ArithmeticException("Not possible");

        }

        else {
            System.out.println("Rrrrr....");
        }
    }
}
