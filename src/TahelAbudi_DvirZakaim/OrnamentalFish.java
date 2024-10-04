package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

public class OrnamentalFish extends AquariumFish {

    public final String fishType = "Ornamental fish";
    public final static int Meal = 3;


    public OrnamentalFish(int age, float length, String[] colors, String pattern) throws GeneralException {
        super(age, length, colors, pattern);
        this.animalType = fishType;
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
