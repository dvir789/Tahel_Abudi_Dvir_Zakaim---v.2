package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;

public class OrnamentalFish extends AquariumFish {

    public static final String[] validPatterns = {"DOTS", "STRIPES", "SPOTS", "PLAIN"};
    private static final String[] availableColors = {"BLACK", "WHITE", "GREEN", "ORANGE", "BLUE", "YELLOW", "BROWN", "GOLD", "RED", "CYAN"};
    public final String fishType = "Ornamental fish";
    public final static int Meal = 3;


    public OrnamentalFish(int age, float length, String[] colors, String pattern) throws GeneralException {
        super(age, length, availableColors);
        setColors(colors);
        setPattern(pattern);
        this.animalType = fishType;
    }

    public void setColors(String[] colors) throws ColorException {
        validateColors(colors);
        this.colors = colors;
    }

    public static String[] getAvailableColors() {
        return availableColors;
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

    public static String[] getAvailablePattern() {
        return validPatterns;
    }

    private void validatePattern(String pattern) throws PatternException {
        if (!Arrays.asList(validPatterns).contains(pattern)) {
            throw new PatternException();
        }
    }

    @Override
    public float mealCalculate() {
        return age < Meal ? Meal : (Meal + length);
    }

    @Override
    public String makeNoise() {
        return "blob";
    }
}
