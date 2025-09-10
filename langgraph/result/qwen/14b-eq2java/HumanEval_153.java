public class HumanEval_153 {
    public static String findPowerfulAddon(String baseClass, List<String> addonList) {
        String powerfulAddon = addonList.get(0);
        int maxStrength = calculateStrength(addonList.get(0));

        for (String addon : addonList) {
            int currentStrength = calculateStrength(addon);
            if (currentStrength > maxStrength) {
                powerfulAddon = addon;
                maxStrength = currentStrength;
            }
        }

        return baseClass + "." + powerfulAddon;
    }

    private static int calculateStrength(String addon) {
        int upperCount = 0;
        int lowerCount = 0;
        for (char c : addon.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCount++;
            }
        }
        return upperCount - lowerCount;
    }
}