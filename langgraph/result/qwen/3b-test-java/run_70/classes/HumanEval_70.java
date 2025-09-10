public class HumanEval_70 {

    public static List<Integer> alternateSortSequence(List<Integer> sequence) {
        List<Integer> result = new ArrayList<>();
        boolean toggle = true;
        
        while (!sequence.isEmpty()) {
            int selectedValue;
            if (toggle) {
                selectedValue = Collections.min(sequence);
            } else {
                selectedValue = Collections.max(sequence);
            }
            
            result.add(selectedValue);
            sequence.remove(Integer.valueOf(selectedValue));
            toggle = !toggle;
        }
        
        return result;
    }
}