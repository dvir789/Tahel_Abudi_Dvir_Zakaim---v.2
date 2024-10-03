package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;

public class ClownFish extends AquariumFish {

    public static final String[] availableColors = {"BLACK", "WHITE", "ORANGE"};
    public final float Meal = 1;
    public final String fishType = "ClownFish";
    public static final String[] validPattern = {"STRIPES"};


    public ClownFish(int age, float length, String[] colors, String pattern) throws GeneralException {
        super(age, length, colors, pattern);
        validateColor();
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

    public static void validateColor(String color) throws ColorException {
        if (!Arrays.toString(availableColors).contains(color)) {
            throw new ColorException();
        }
    }

    private void validateColor() throws GeneralException {
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
