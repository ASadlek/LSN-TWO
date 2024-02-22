package lsn.example.io;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static InputValidator instance;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (instance == null) {
            instance = new InputValidator();
        }
        return instance;
    }

    public void validateInput(String input) throws IOException {
        String pattern = "^-?\\d+(\\s-?\\d+)*$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        if (!matcher.matches()) {
            throw new IOException("Enter ONLY numbers separated by spaces! No other symbols are permitted!");
        }
    }
}
