package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;

public class GoldFish extends AquariumFish {

    public static final String[] validColors = {"BLACK", "YELLOW", "GOLD", "ORANGE"};
    public static final String[] validPattern = {"PLAIN"};

    public final String fishType = "GoldFish";
    public final float Meal = 1;

    public GoldFish(int age, float length, String[] colors, String pattern) throws GeneralException{
        super(age, length, colors, pattern);
        validateGoldFishColors(colors);
        validateGoldPattern(pattern);
        this.animalType = fishType;
    }

    private void validateGoldFishColors(String[] colors) throws GeneralException {
        for (String color : colors) {
            validateColor(color);
        }
    }

    public static void validateColor(String color) throws ColorException {
        if (!Arrays.asList(validColors).contains(color)) {
            throw new ColorException();
        }
    }

        private void validateGoldPattern(String pattern) throws PatternException {
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
