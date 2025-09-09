import java.util.List;

public class HumanEval_8 {

    public static Tuple sumProduct(List<Integer> numbers) {
        int sumValue = 0;
        int prodValue = 1;

        for (int n : numbers) {
            sumValue += n;
            prodValue *= n;
        }

        return new Tuple(sumValue, prodValue);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Tuple result = sumProduct(numbers);
        System.out.println("Sum: " + result.sum + ", Product: " + result.prod);
    }
}

class Tuple {
    int sum;
    int prod;

    Tuple(int sum, int prod) {
        this.sum = sum;
        this.prod = prod;
    }
}