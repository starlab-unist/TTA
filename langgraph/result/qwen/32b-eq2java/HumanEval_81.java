import java.util.ArrayList;
import java.util.List;

public class HumanEval_81 {
    public List<String> convertGpasToLetters(List<Double> gpas) {
        double[][] gradeMapping = {
            {4.0, "A+"},
            {3.7, "A"},
            {3.3, "A-"},
            {3.0, "B+"},
            {2.7, "B"},
            {2.3, "B-"},
            {2.0, "C+"},
            {1.7, "C"},
            {1.3, "C-"},
            {1.0, "D+"},
            {0.7, "D"},
            {0.0, "D-"},
            {-1.0, "E"}  // Added -1.0 to handle the else case
        };

        List<String> letterGrades = new ArrayList<>();
        int index = 0;
        while (index < gpas.size()) {
            double gpa = gpas.get(index);
            while (gpa <= gradeMapping[index][0]) {
                index++;
            }
            letterGrades.add(gradeMapping[index - 1][1]);
            index++;
        }

        return letterGrades;
    }
}