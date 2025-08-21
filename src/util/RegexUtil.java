package util;

import java.util.regex.Pattern;

public class RegexUtil {

    // ===== Common regex patterns =====
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    // VN phone number (start with 0, 84, or +84, 9–10 digits total)
    private static final Pattern PHONE_PATTERN = Pattern.compile(
        "^(?:\\+?84|0)(?:\\d){9}$"
    );

    // Simple address check (letters, numbers, spaces, commas, dots, hyphens)
    private static final Pattern ADDRESS_PATTERN = Pattern.compile(
        "^[\\p{L}0-9\\s,.-]{5,100}$"
    );

    // Only letters & spaces (for names)
    private static final Pattern NAME_PATTERN = Pattern.compile(
        "^[\\p{L}\\s]{2,50}$"
    );

    // ===== Check methods =====
    public static boolean isEmail(String input) {
        return input != null && EMAIL_PATTERN.matcher(input).matches();
    }

    public static boolean isPhoneNumber(String input) {
        return input != null && PHONE_PATTERN.matcher(input).matches();
    }

    public static boolean isAddress(String input) {
        return input != null && ADDRESS_PATTERN.matcher(input).matches();
    }

    public static boolean isName(String input) {
        return input != null && NAME_PATTERN.matcher(input).matches();
    }

    // Generic method if you want to pass your own regex
    public static boolean matches(String input, String regex) {
        return input != null && Pattern.matches(regex, input);
    }
}
