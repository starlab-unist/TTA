public class HumanEval_81 {
    public static String[] convertGpasToLetters(double[] gpas) {
        String[] gradeMapping = {
            "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E"
        };

        String[] letterGrades = new String[gpas.length];
        int index = 0;

        while (index < gpas.length) {
            double gpa = gpas[index];
            int i = 0;
            while (i < gradeMapping.length && gpa > gradeMapping[i]) {
                i++;
            }
            letterGrades[index] = gradeMapping[i - 1];
            index++;
        }

        return letterGrades;
    }
}