package TahelAbudi_DvirZakaim;

import java.util.Arrays;

public class GoldFish extends AquariumFish {

    private final String[] availableColors = {"BLACK", "YELLOW", "GOLD", "ORANGE"};
    private final String validPattern = "PLAIN";
    public final String type = "GoldFish";
    public final float Meal = 1;


    public GoldFish(int age, float length, String[] colors, String pattern) {
        super(age, length, colors, pattern);
        super.type = type;
    }


    private boolean isColorValid(String[] colors) {
        for (String color : colors) {
            if (!Arrays.toString(availableColors).contains(color)) {
                return false;
            }
        }
        return true;
    }

    private void validateColor() throws Exception {
        if (!isColorValid(colors)) {
            throw new Exception("Color not valid");
        }
    }

    @Override
    public float MealCalculator() {
        return Meal;
    }


}
