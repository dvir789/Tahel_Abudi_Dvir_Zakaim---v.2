package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.AgeException;
import TahelAbudi_DvirZakaim.exceptions.GeneralException;
import TahelAbudi_DvirZakaim.exceptions.LionGenderException;
import TahelAbudi_DvirZakaim.exceptions.PredatorWeightException;

import java.util.Objects;

public class Lion extends Predator{

    private static final String type = "Lion";
    private final int MAX_FOOD = 25;

    //constructor
    public Lion(String name, int age, float weight, String gender) throws GeneralException {
        super(name, age, weight, gender);
        this.animalType = type;
    }

    @Override
    public float mealCalculate() {
        double factor = (Objects.equals(gender, "male") ? 0.02 : 0.03);
        double meal = Math.floor(factor * age * weight);

        return meal > MAX_FOOD ? MAX_FOOD : (float) meal;
    }

    @Override
    public String makeNoise() {
        return "ROAR";
    }

}
