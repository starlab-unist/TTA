public class HumanEval_37 {

    public static List<Integer> sortEven(List<Integer> l) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int i = 0; i < l.size(); i++) {
            if (i % 2 == 0) {
                evens.add(l.get(i));
            } else {
                odds.add(l.get(i));
            }
        }

        Collections.sort(evens);

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < evens.size() && j < odds.size()) {
            ans.add(evens.get(i));
            ans.add(odds.get(j));
            i++;
            j++;
        }

        if (evens.size() > odds.size()) {
            ans.add(evens.get(evens.size() - 1));
        }

        return ans;
    }
}