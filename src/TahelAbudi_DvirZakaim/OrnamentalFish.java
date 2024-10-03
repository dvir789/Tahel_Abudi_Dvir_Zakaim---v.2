package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

public class OrnamentalFish extends AquariumFish {

    public final String fishType = "Ornamental fish";
    public final static int Meal = 3;


    public OrnamentalFish(int age, float length, String[] colors, String pattern) throws GeneralException {
        super(age, length, colors, pattern);
        this.type = fishType;
    }


//    @Override
//    public boolean areColorsValid() {
//        return false;
//    }

//    public void addColor(String userColor) {
//        if (!isValidColor(userColor)) {
//            return;
//        }

//        if (numOfColors >= colors.length) {
//            colors = Arrays.copyOf(colors, colors.length * 2);
//        }
//        colors[numOfColors++] = userColor.toUpperCase();
//    }

    @Override
    public float MealCalculator() {
        return age < Meal ? Meal : (Meal + length);
    }

    @Override
    public String makeNoise() {
        return "blob";
    }
}
