public final class StringUtils {

    private StringUtils() {
    }

    public static String normalizeSpaces(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        String trimmed = input.trim();
        StringBuilder sb = new StringBuilder();

        boolean prevIsSpace = false;

        for (int i = 0; i < trimmed.length(); i++) {
            char c = trimmed.charAt(i);

            if (c == ' ' || c == '\t' || c == '\n') {
                if (!prevIsSpace) {
                    sb.append(' ');
                    prevIsSpace = true;
                }
            } else {
                sb.append(c);
                prevIsSpace = false;
            }
        }

        return sb.toString();
    }

    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }

        return sb.toString();
    }

    public static boolean isPalindrome(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        StringBuilder cleaned = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c != ' ') {
                if (c >= 'A' && c <= 'Z') {
                    c = (char)(c + 32); // 소문자 변환 (초보 방식)
                }
                cleaned.append(c);
            }
        }

        String str = cleaned.toString();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static int countWords(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c != ' ' && c != '\t' && c != '\n') {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        return count;
    }
}