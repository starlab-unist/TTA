public class HumanEval_93 {
    public String transformMessage(String inputText) {
        String vowelSet = "aeiouAEIOU";
        StringBuilder modifiedText = new StringBuilder(inputText).reverse().toString();
        StringBuilder result = new StringBuilder();

        for (char c : modifiedText.toString().toCharArray()) {
            char mappedChar = c;
            if (vowelSet.indexOf(c) != -1) {
                mappedChar = (char) (c + 2);
            }
            result.append(mappedChar);
        }

        return result.reverse().toString();
    }
}
```

**Note:** The provided Python code swaps the case of the input text and then maps vowels to the next second character in the ASCII table. However, the Java code snippet above incorrectly reverses the string before processing. To maintain the original functionality, the Java code should be adjusted as follows:

```java
public class HumanEval_93 {
    public String transformMessage(String inputText) {
        String vowelSet = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();

        for (char c : inputText.toCharArray()) {
            char mappedChar = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
            if (vowelSet.indexOf(mappedChar) != -1) {
                mappedChar = (char) (mappedChar + 2);
            }
            result.append(mappedChar);
        }

        return result.toString();
    }
}