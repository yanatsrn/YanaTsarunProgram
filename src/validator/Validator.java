package validator;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
    private static final Pattern STRING_PATTERN = Pattern.compile("^[\\p{L}]+$");

    private Validator() {

    }

    public static boolean isValidString(String string) {
        boolean isValid = true;
        if (string == null || !STRING_PATTERN.matcher(string).matches()) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidPhone(String phone) {
        boolean isValid = true;
        if (phone == null || !PHONE_PATTERN.matcher(phone).matches()) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidEmail(String email) {
        boolean isValid = true;
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            isValid = false;
        }
        return isValid;
    }

}
