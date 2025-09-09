public class HumanEval_153 {
    public String findPowerfulAddon(String baseClass, String[] addonList) {
        String powerfulAddon = addonList[0];
        int maxStrength = calculateStrength(addonList[0]);

        for (String addon : addonList) {
            int currentStrength = calculateStrength(addon);
            if (currentStrength > maxStrength) {
                powerfulAddon = addon;
                maxStrength = currentStrength;
            }
        }

        return baseClass + "." + powerfulAddon;
    }

    private int calculateStrength(String addon) {
        int strength = 0;
        for (char c : addon.toCharArray()) {
            if (Character.isUpperCase(c)) {
                strength++;
            } else if (Character.isLowerCase(c)) {
                strength--;
            }
        }
        return strength;
    }
}