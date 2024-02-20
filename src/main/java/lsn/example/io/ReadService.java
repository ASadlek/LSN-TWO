package lsn.example.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadService {

    private static ReadService instance;
    private final PrintService printService;

    private ReadService() {
        printService = PrintService.getInstance();
    }

    public static ReadService getInstance() {
        if (instance == null) {
            instance = new ReadService();
        }
        return instance;
    }

    public String readInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printService.printEntry();
        return reader.readLine().trim();
    }

}
