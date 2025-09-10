import java.util.ArrayList;
import java.util.List;

public class HumanEval_81 {

    public static List<String> convertGpasToLetters(List<Double> gpas) {
        List<double[]> gradeMapping = new ArrayList<>();
        gradeMapping.add(new double[]{4.0, 0});
        gradeMapping.add(new double[]{3.7, 1});
        gradeMapping.add(new double[]{3.3, 2});
        gradeMapping.add(new double[]{3.0, 3});
        gradeMapping.add(new double[]{2.7, 4});
        gradeMapping.add(new double[]{2.3, 5});
        gradeMapping.add(new double[]{2.0, 6});
        gradeMapping.add(new double[]{1.7, 7});
        gradeMapping.add(new double[]{1.3, 8});
        gradeMapping.add(new double[]{1.0, 9});
        gradeMapping.add(new double[]{0.7, 10});
        gradeMapping.add(new double[]{0.0, 11});
        gradeMapping.add(new double[]{-1.0, 12}); // Added -1.0 to handle the else case

        String[] letterGrades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E"};
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < gpas.size()) {
            double gpa = gpas.get(index);
            while (gpa <= gradeMapping.get(index)[0]) {
                index++;
            }
            result.add(letterGrades[(int) gradeMapping.get(index - 1)[1]]);
            index++;
        }

        return result;
    }
}