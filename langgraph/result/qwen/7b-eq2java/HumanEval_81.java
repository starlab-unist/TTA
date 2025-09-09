import java.util.ArrayList;
import java.util.List;

public class HumanEval_81 {

    public static List<String> convertGpasToLetters(List<Double> grades) {
        List<double[]> gradeMapping = new ArrayList<>();
        gradeMapping.add(new double[]{4.0, 'A'});
        gradeMapping.add(new double[]{3.7, 'A'});
        gradeMapping.add(new double[]{3.3, 'A'});
        gradeMapping.add(new double[]{3.0, 'B'});
        gradeMapping.add(new double[]{2.7, 'B'});
        gradeMapping.add(new double[]{2.3, 'B'});
        gradeMapping.add(new double[]{2.0, 'C'});
        gradeMapping.add(new double[]{1.7, 'C'});
        gradeMapping.add(new double[]{1.3, 'C'});
        gradeMapping.add(new double[]{1.0, 'D'});
        gradeMapping.add(new double[]{0.7, 'D'});
        gradeMapping.add(new double[]{0.0, 'D'});
        gradeMapping.add(new double[]{-1.0, 'E'});

        List<String> letterGrades = new ArrayList<>();
        int index = 0;
        for (Double gpa : grades) {
            while (gpa <= gradeMapping.get(index)[0]) {
                index++;
            }
            letterGrades.add(String.valueOf((char) gradeMapping.get(index - 1)[1]));
            index = 0;
        }

        return letterGrades;
    }
}