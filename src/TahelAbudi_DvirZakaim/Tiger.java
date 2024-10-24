package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.GeneralException;

import java.util.Objects;

public class Tiger extends Predator{

    private static final String type = "Tiger";

    public Tiger(String name, int age, float weight, String gender) throws GeneralException {
        super(name, age, weight, gender);
        super.animalType = type;
    }

    @Override
    public String makeNoise() {
        return "roar";
    }

    @Override
    public float mealCalculate() {
        double factor = (Objects.equals(gender, "male") ? 0.02 : 0.03);
        double meal = Math.floor(factor * age * weight);

        return (float)meal;
    }
}
