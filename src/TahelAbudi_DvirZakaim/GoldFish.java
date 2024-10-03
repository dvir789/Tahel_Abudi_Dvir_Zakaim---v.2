package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;

public class GoldFish extends AquariumFish {

    public static final String[] availableColors = {"BLACK", "YELLOW", "GOLD", "ORANGE"};
    public static final String[] validPattern = {"PLAIN"};

    public final String fishType = "GoldFish";
    public final float Meal = 1;

    public GoldFish(int age, float length, String[] colors, String pattern) throws GeneralException{
        super(age, length, colors, pattern);
        validateColor(colors);
        this.type = fishType;
    }

    private boolean isColorValid(String[] colors) {
        for (String color : colors) {
            if (!Arrays.toString(availableColors).contains(color)) {
                return false;
            }
        }
        return true;
    }

    private void validateColor(String[] colors) throws GeneralException {
        if (!isColorValid(colors)) {
            throw new GeneralException("Color not valid, choose from the list: " + Arrays.toString(availableColors));
        }
    }

//    @Override
//    public boolean areColorsValid() {
//        return false;
//    }

    @Override
    public String makeNoise() {
        return "blob";
    }


    @Override
    public float mealCalculate() {
        return Meal;
    }
}
