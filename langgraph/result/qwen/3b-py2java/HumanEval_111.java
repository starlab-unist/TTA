import java.util.HashMap;
import java.util.Map;

public class HumanEval_111 {

    public static Map<String, Integer> histogram(String test) {
        Map<String, Integer> dict1 = new HashMap<>();
        String[] list1 = test.split(" ");
        int t = 0;

        for (String i : list1) {
            if (list1.length > 0 && list1.count(i) > t) {
                t = list1.count(i);
            }
        }

        if (t > 0) {
            for (String i : list1) {
                if (list1.count(i) == t) {
                    dict1.put(i, t);
                }
            }
        }

        return dict1;
    }
}
```

Note: The `count` method is not a valid method in Java's `String` class. It seems there might be a misunderstanding in the original Python code. Assuming you meant to use `list1.indexOf(i) > -1` to check if the string is present in the list, here's the corrected version:

```java
import java.util.HashMap;
import java.util.Map;

public class HumanEval_111 {

    public static Map<String, Integer> histogram(String test) {
        Map<String, Integer> dict1 = new HashMap<>();
        String[] list1 = test.split(" ");
        int t = 0;

        for (String i : list1) {
            if (i != null && !i.isEmpty() && list1.length > 0 && list1.indexOf(i) > -1) {
                t = Math.max(t, list1.length);
            }
        }

        if (t > 0) {
            for (String i : list1) {
                if (list1.length > 0 && list1.indexOf(i) > -1 && list1.length == t) {
                    dict1.put(i, t);
                }
            }
        }

        return dict1;
    }
}