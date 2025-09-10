import java.util.List;

public class HumanEval_12 {

    public static String findLongestString(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return null;
        }

        int maxLength = 0;
        for (String element : stringList) {
            if (element.length() > maxLength) {
                maxLength = element.length();
            }
        }

        for (String element : stringList) {
            if (element.length() == maxLength) {
                return element;
            }
        }

        return null;
    }
}