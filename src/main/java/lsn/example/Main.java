package lsn.example;

import lsn.example.io.InputValidator;
import lsn.example.pair.PairService;
import lsn.example.io.PrintService;
import lsn.example.io.ReadService;

public class Main {

    public static void main(String[] args) {
        //init singleton instances
        PrintService printService = PrintService.getInstance();
        ReadService readService = ReadService.getInstance();
        PairService pairService = PairService.getInstance();
        InputValidator inputValidator = InputValidator.getInstance();

        //run app in a loop
        while (true) {
            try {
                String input = readService.readInput();
                if (input.equalsIgnoreCase("exit")) {
                    printService.printExit();
                    break;
                }
                inputValidator.validateInput(input);
                pairService.findPairs(input);
            } catch (Exception exception) {
                printService.printExceptionMessage(exception.getMessage());
            }

        }
    }

}
