public class HumanEval_153 {
    public static String findPowerfulAddon(String baseClass, String[] addonList) {
        String powerfulAddon = addonList[0];
        int maxStrength = 0;

        for (String addon : addonList) {
            int currentStrength = 0;
            for (char c : addon.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    currentStrength++;
                } else if (Character.isLowerCase(c)) {
                    currentStrength--;
                }
            }

            if (currentStrength > maxStrength) {
                powerfulAddon = addon;
                maxStrength = currentStrength;
            }
        }

        return baseClass + "." + powerfulAddon;
    }
}