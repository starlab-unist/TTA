public class HumanEval_153 {
    public static String findPowerfulAddon(String baseClass, List<String> extensionList) {
        String powerfulAddon = extensionList.get(0);
        int maxStrength = calculateStrength(powerfulAddon);

        for (String addon : extensionList) {
            int currentStrength = calculateStrength(addon);
            if (currentStrength > maxStrength) {
                powerfulAddon = addon;
                maxStrength = currentStrength;
            }
        }

        return baseClass + "." + powerfulAddon;
    }

    private static int calculateStrength(String addon) {
        long upperCaseCount = addon.chars().filter(Character::isUpperCase).count();
        long lowerCaseCount = addon.chars().filter(Character::isLowerCase).count();
        return (int) (upperCaseCount - lowerCaseCount);
    }
}