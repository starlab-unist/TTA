public class HumanEval_37 {

    public static List<Integer> sortEven(List<Integer> numbers) {
        List<Integer> evenElements = new ArrayList<>();
        List<Integer> oddElements = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                evenElements.add(numbers.get(i));
            } else {
                oddElements.add(numbers.get(i));
            }
        }

        Collections.sort(evenElements);

        List<Integer> result = new ArrayList<>();
        int index = 0;

        while (index < oddElements.size()) {
            result.add(evenElements.get(index));
            result.add(oddElements.get(index));
            index++;
        }

        if (evenElements.size() > oddElements.size()) {
            result.add(evenElements.get(evenElements.size() - 1));
        }

        return result;
    }
}