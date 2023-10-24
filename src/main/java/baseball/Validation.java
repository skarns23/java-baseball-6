package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {
    public static void validationInputLength(String inputString, int maxSize) {
        if (inputString.length() != maxSize) {
            throw new IllegalArgumentException("잘못된 길이를 입력하셨습니다.");
        }
    }

    public static void validationValueInRange(String inputString, int startInclusive, int endInclusive) {
        String pattern = "^[" + startInclusive + "-" + endInclusive + "]*$";
        if (!Pattern.matches(pattern, inputString)) {
            throw new IllegalArgumentException(startInclusive + "~" + endInclusive + "까지의 숫자만 입력 가능합니다.");
        }
    }

    public static void validationIsUnique(List<Integer> inputNumList, int maxSize) {
        Set<Integer> set = new HashSet<>(inputNumList);
        if (set.size() != maxSize) {
            throw new IllegalArgumentException("서로 다른 수를 입력해야 합니다.");
        }
    }
}
