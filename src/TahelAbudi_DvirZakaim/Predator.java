package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Objects;

public abstract class Predator extends Animal {

    protected String name;
    protected float weight;
    protected String gender;

    public Predator(String name, int age, float weight, String gender) throws GeneralException {
        super(age);
        setName(name);
        setWeight(weight);
        setGender(gender);
    }

    private void setName(String name) throws NameException {
        Validation.validateName(name);
        this.name = name;
    }

    public void setWeight(float weight) throws PredatorWeightException {
        validateWeight(weight);
        this.weight = weight;
    }

    public static void validateWeight(float weight) throws PredatorWeightException {
        if (weight <= 0) {
            throw new PredatorWeightException();
        }
    }

    public void setGender(String gender) throws LionGenderException {
        validateGender(gender);
        this.gender = gender;
    }

    public static void validateGender(String gender) throws LionGenderException {
        if (!(Objects.equals(gender, "male") || Objects.equals(gender, "female"))) {
            throw new LionGenderException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(animalType).append(": ").append(name).append(" at age: ").append(age).append(" with weight: ")
                .append(weight).append(" gender: ").append(gender);
        return sb.toString();
    }
}
