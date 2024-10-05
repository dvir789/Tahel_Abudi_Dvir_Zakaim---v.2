package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;

public class ClownFish extends AquariumFish {

    private static final String[] availableColors = {"BLACK", "WHITE", "ORANGE"};
    public final float Meal = 1;
    public final String fishType = "ClownFish";
    public static final String[] validPattern = {"STRIPES"};


    public ClownFish(int age, float length, String[] colors, String pattern) throws GeneralException {
        super(age, length, availableColors);
        setColors(colors);
        setPattern(pattern);
        this.animalType = fishType;
    }

    public void setColors(String[] colors) throws ColorException {
        validateColors(colors);
        this.colors = colors;
    }

    private void validateColors(String[] colors) throws ColorException {
        for (String color : colors) {
            validateColor(color);
        }
    }

    public static void validateColor(String color) throws ColorException {
        if (!Arrays.asList(availableColors).contains(color)) {
            throw new ColorException();
        }
    }

    public void setPattern(String pattern) throws PatternException {
        validatePattern(pattern);
        this.pattern = pattern;
    }

    public static String[] getAvailableColors() {
        return availableColors;
    }

    public static String[] getAvailablePattern() {
        return validPattern;
    }

    private void validatePattern(String pattern) throws PatternException {
        if (!Arrays.asList(validPattern).contains(pattern)) {
            throw new PatternException();
        }
    }

    @Override
    public String makeNoise() {
        return "blob";
    }

    @Override
    public float mealCalculate() {
        return Meal;
    }
}
