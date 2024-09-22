package TahelAbudi_DvirZakaim;

import java.util.Arrays;

public class ClownFish extends AquariumFish {

    private final String[] availableColors = {"BLACK", "WHITE", "ORANGE"};
    private final String validPattern = "STRIPES";
    public final String type = "ClownFish";
    public final float Meal = 2;


    public ClownFish(int age, float length, String[] colors, String pattern) {
        super(age, length, colors, pattern);
        super.type = type;
    }


    private boolean isValidColor(String[] colors) {
        for (String color : colors) {
            if (!Arrays.toString(availableColors).contains(color)) {
                return false;
            }
        }
        return true;
    }


    private void validateColor() throws Exception {
        if (!isValidColor(colors)) {
            throw new Exception("Color not valid");
        }
    }



    @Override
    public float MealCalculator() {
        return Meal;
    }


}
