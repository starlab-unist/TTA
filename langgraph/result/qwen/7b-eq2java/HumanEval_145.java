import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_145 {

    public static int[] orderByPoints(int[] nums) {
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                int sign1 = n1 < 0 ? -1 : 1;
                int sign2 = n2 < 0 ? -1 : 1;
                int absValue1 = Math.abs(n1);
                int absValue2 = Math.abs(n2);
                int[] digits1 = String.valueOf(absValue1).chars().map(Character::getNumericValue).toArray();
                int[] digits2 = String.valueOf(absValue2).chars().map(Character::getNumericValue).toArray();
                digits1[0] *= sign1;
                digits2[0] *= sign2;
                return Arrays.stream(digits1).sum() - Arrays.stream(digits2).sum();
            }
        });
        return nums;
    }
}