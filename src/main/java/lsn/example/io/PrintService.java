package lsn.example.io;

import lsn.example.Pair;

import java.util.List;

public class PrintService {

    private static PrintService instance;

    private PrintService() {
    }

    public static PrintService getInstance() {
        if (instance == null) {
            instance = new PrintService();
        }
        return instance;
    }

    public void printEntry() {
        System.out.println("Enter numbers separated by spaces or type 'exit' to quit:");
    }

    public void printExceptionMessage(String message) {
        System.out.println("Wrong Input! " + message + "\n");
    }

    public void printExit() {
        System.out.println("Exiting... \n");
    }

    public void printCorrectOutput(List<Pair> pairs) {
        for (Pair pair : pairs) {
            System.out.println(pair.getLowerValue() + " " + pair.getHigherValue());
        }
        if (pairs.isEmpty()) {
            System.out.println("No pairs found!\n");
        } else {
            System.out.println();
        }
    }

}
