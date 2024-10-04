package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;

public class ClownFish extends AquariumFish {

    public static final String[] validColors = {"BLACK", "WHITE", "ORANGE"};
    public final float Meal = 1;
    public final String fishType = "ClownFish";
    public static final String[] validPattern = {"STRIPES"};


    public ClownFish(int age, float length, String[] colors, String pattern) throws GeneralException {
        super(age, length, colors, pattern);
        validateClownColors(colors);
        validateClownPattern(pattern);
        this.animalType = fishType;
    }

    private void validateClownColors(String[] colors) throws ColorException {
        for (String color : colors) {
            validateColor(color);
        }
    }

    public static void validateColor(String color) throws ColorException {
        if (!Arrays.asList(validColors).contains(color)) {
            throw new ColorException();
        }
    }

    private void validateClownPattern(String pattern) throws PatternException {
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
