public class HumanEval_112 {
    public static Pair<String, Boolean> filterAndCheckPalindrome(String inputString, String charsToRemove) {
        StringBuilder filteredString = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            if (charsToRemove.indexOf(character) == -1) {
                filteredString.append(character);
            }
        }
        boolean isPalindrome = filteredString.toString().equals(filteredString.reverse().toString());
        return new Pair<>(filteredString.toString(), isPalindrome);
    }
}
```

Note: In Java, there is no built-in `Pair` class, so you would need to either use a library like Apache Commons Lang or define your own `Pair` class. Here is a simple implementation of a `Pair` class:

```java
public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}